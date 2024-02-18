package Project.adapters;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * This class is a Gson adapter for serializing and deserializing LocalDate objects.
 */
public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    /**
     * Serializes a LocalDate object to a JsonElement.
     *
     * @param src       The LocalDate object to serialize.
     * @param typeOfSrc The type of the source object.
     * @param context   The serialization context.
     * @return The serialized JsonElement.
     */
    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(src));
    }
    /**
     * Deserializes a JsonElement to a LocalDate object.
     *
     * @param json      The JsonElement to deserialize.
     * @param typeOfT   The type of the deserialized object.
     * @param context   The deserialization context.
     * @return The deserialized LocalDate object.
     * @throws JsonParseException If an error occurs during deserialization.
     */
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDate.parse(json.getAsString(), formatter);
    }
}
