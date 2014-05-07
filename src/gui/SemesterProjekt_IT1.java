/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Parser.TransactionParser;
import domain.System_;
import domain.Transaction;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author emilfrisk
 */
public class SemesterProjekt_IT1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        TransactionParser transactionParser = new TransactionParser();
        System_ sys = new System_();
        
        File file = new File("transactions.xml");
        
        List<Transaction> transactionList = transactionParser.readFile(file);
        
        sys.receiveTransactions(transactionList);
    }
    
}
