
package epi.test_framework.serialization_traits;

import epi.BinaryTree;
import epi.BinaryTreeNode;
import epi.BstNode;
import epi.ListNode;
import epi.test_framework.EpiUserType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TraitsFactory {
  private static final Map<Type, SerializationTrait> PRIMITIVE_TYPES_MAPPING;

  static {
    PRIMITIVE_TYPES_MAPPING = new HashMap<>();
    PRIMITIVE_TYPES_MAPPING.put(String.class, new StringTrait());
    PRIMITIVE_TYPES_MAPPING.put(Integer.class, new IntegerTrait());
      PRIMITIVE_TYPES_MAPPING.put(int.class, new IntegerTrait());
      PRIMITIVE_TYPES_MAPPING.put(Short.class, new ShortTrait());
      PRIMITIVE_TYPES_MAPPING.put(short.class, new ShortTrait());
      PRIMITIVE_TYPES_MAPPING.put(Long.class, new LongTrait());
      PRIMITIVE_TYPES_MAPPING.put(long.class, new LongTrait());
      PRIMITIVE_TYPES_MAPPING.put(Character.class, new CharacterTrait());
      PRIMITIVE_TYPES_MAPPING.put(char.class, new CharacterTrait());
      PRIMITIVE_TYPES_MAPPING.put(Boolean.class, new BooleanTrait());
      PRIMITIVE_TYPES_MAPPING.put(boolean.class, new BooleanTrait());
      PRIMITIVE_TYPES_MAPPING.put(Float.class, new FloatTrait());
      PRIMITIVE_TYPES_MAPPING.put(float.class, new FloatTrait());
      PRIMITIVE_TYPES_MAPPING.put(Double.class, new DoubleTrait());
      PRIMITIVE_TYPES_MAPPING.put(double.class, new DoubleTrait());
  }

  @SuppressWarnings("unchecked")
  public static SerializationTrait getTrait(Type type) {
    if (type.equals(Void.TYPE)) {
      return new VoidTrait();
    }
    if (type instanceof ParameterizedType) {
      ParameterizedType pt = (ParameterizedType)type;
      Type ty = pt.getRawType();
      if (ty.equals(List.class)) {
        return new ListTrait(getTrait(getInnerGenericType(pt, 0)));
      }
      if (ty.equals(Iterable.class)) {
        return new ListTrait(getTrait(getInnerGenericType(pt, 0)));
      }
      if (ty.equals(Set.class)) {
        return new SetTrait(getTrait(getInnerGenericType(pt, 0)));
      }
      if (ty.equals(BinaryTreeNode.class) || ty.equals(BinaryTree.class) ||
          ty.equals(BstNode.class)) {
        return new BinaryTreeTrait((Class<?>)ty,
                                   getTrait(getInnerGenericType(pt, 0)));
      }
      if (ty.equals(ListNode.class)) {
        return new LinkedListTrait(getTrait(getInnerGenericType(pt, 0)));
      }
    }

    SerializationTrait mapped = PRIMITIVE_TYPES_MAPPING.get(type);
    if (mapped != null) {
      return mapped;
    }

    if (type instanceof Class) {
      EpiUserType ann =
          (EpiUserType)((Class)type).getAnnotation(EpiUserType.class);

      return new UserTypeTrait((Class)type, ann);
    }

    throw new RuntimeException("Unsupported argument type: " +
                               type.getTypeName());
  }

  private static Type getInnerGenericType(Type type, int idx) {
    if (type instanceof ParameterizedType) {
      return ((ParameterizedType)type).getActualTypeArguments()[idx];
    } else {
      throw new RuntimeException(type.getTypeName() +
                                 " has no generic type arguments");
    }
  }
}
