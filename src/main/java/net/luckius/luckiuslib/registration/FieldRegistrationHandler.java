package net.luckius.luckiuslib.registration;

import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;

public class FieldRegistrationHandler {
	public static <T> void register(Class<? extends AutoRegistryContainer<T>> clazz, String modId) {
		try {
			// Get the registry and content type from the provided class
			AutoRegistryContainer<T> container = clazz.getDeclaredConstructor().newInstance();
			Registry<T> registry = container.getRegistry();
			Class<T> contentType = container.getRegistryContentType();

			// Get all the fields in the class
			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {
				// Check if the field is of type assignable to the content type and has the AssignedName annotation
				if (contentType.isAssignableFrom(field.getType()) && !field.isSynthetic()) {
					// Make the field accessible and get its value
					field.setAccessible(true);
					T item = contentType.cast(field.get(null)); // null because the fields are static

					// Get the assigned name from the annotation if present, otherwise use the field's name
					String assignedName = field.isAnnotationPresent(AssignedName.class)
							? field.getAnnotation(AssignedName.class).value().toLowerCase()
							: field.getName().toLowerCase();

					// Get the Identifier for the item using the assigned name
					Identifier identifier = new Identifier(modId, assignedName);

					// Register the item to the registry
					Registry.register(registry, identifier, item);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to register items from " + clazz.getName(), e);
		}
	}
}
