package Parser;

import domain.Transaction;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TransactionParser {

    public List<Transaction> readFile(File f) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(f);

        List<Transaction> transactionList = new ArrayList<>();

        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Transaction transaction = new Transaction();
                int transactionId = Integer.parseInt(node.getAttributes().getNamedItem("transactionId").getNodeValue());
                transaction.setTransactionId(transactionId);

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().getTextContent().trim();
                        Date date = null;
                        switch (cNode.getNodeName()) {
                            case "type":
                                transaction.setType(content);
                                break;
                            case "date":
                                SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
                                try {
                                    date = formatter.parse(content);
                                } catch (Exception e) {
                                }
                                transaction.setDate(date);
                                break;
                            case "amount":
                                double amount = Double.valueOf(content);
                                transaction.setAmount(amount);
                                break;
                            case "store":
                                transaction.setStore(content);
                                break;
                            case "active":
                                boolean active = Boolean.parseBoolean(content);
                                transaction.setActive(active);
                                break;
                            case "userId":
                                int userId = Integer.parseInt(content);
                                transaction.setUserId(userId);
                                break;
                        }
                    }
                }
                transactionList.add(transaction);
            }
        }

        return transactionList;
    }
}
