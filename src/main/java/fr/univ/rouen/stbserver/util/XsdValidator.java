package fr.univ.rouen.stbserver.util;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;

public class XsdValidator {
    private static final String XSD_PATH = "/xsd/stb23.tp1.xsd"; 
    // Chemin vers le fichier XSD

    public static boolean validateXml(String stb23) {
        try {
            // Création de la fabrique de schéma
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Chargement du schéma XSD
            Schema schema = schemaFactory.newSchema(new StreamSource(XsdValidator.class.getClassLoader().getResourceAsStream(XSD_PATH)));

            // Création du validateur
            Validator validator = schema.newValidator();

            // Validation du flux XML
            validator.validate(new StreamSource(new StringReader(stb23)));

            return true; // Le flux XML est valide
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false; // Le flux XML est invalide
        }
    }
}

