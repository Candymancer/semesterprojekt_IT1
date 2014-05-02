package Parser;

import domain.Transaction;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TransactionParser {

    public void readFile(File f) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document document = builder.parse(f);
        
        List<Transaction> transactionList = new ArrayList<>();
        
        throw new UnsupportedOperationException();
    }
}
