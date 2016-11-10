package co.jg.vlab.model;
import java.sql.SQLException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.postgresql.util.PGInterval;

@Converter
public class IntervalConverter implements AttributeConverter<Double, String> {

    @Override
    public String convertToDatabaseColumn(Double attribute) {
        Long seconds = (long)(attribute / 1000);
        String pgInterval = new String(seconds + " seconds");
        return pgInterval;
    }

    @Override
    public Double convertToEntityAttribute(String dbData) {
        try {
            PGInterval interval = new PGInterval(dbData);
            return interval.getSeconds() * 1000;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
