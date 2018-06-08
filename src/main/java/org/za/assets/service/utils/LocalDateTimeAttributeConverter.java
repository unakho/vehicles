package org.za.assets.service.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author unakho.kama
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    public LocalDateTimeAttributeConverter() {
    }

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime datetime) {
        return datetime == null ? null : Timestamp.valueOf(datetime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }

}
