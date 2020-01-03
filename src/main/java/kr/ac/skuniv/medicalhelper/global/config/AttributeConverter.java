package kr.ac.skuniv.medicalhelper.global.config;

import javax.persistence.Converter;

@Converter
public interface AttributeConverter<X, Y> {
    public Y convertToDatabaseColumn(X attribute); //Entity to Database
    public X convertToEntityAttribute(Y dbData); //Database to Entity
}
