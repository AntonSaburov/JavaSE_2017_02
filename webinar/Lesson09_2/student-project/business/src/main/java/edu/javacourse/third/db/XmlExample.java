package edu.javacourse.third.db;

import edu.javacourse.third.domain.PersonAdult;
import edu.javacourse.third.domain.PersonChild;
import edu.javacourse.third.domain.StudentOrder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by antonsaburov on 20.03.17.
 */
public class XmlExample
{
    public static void main(String[] args) {
        List<StudentOrder> soList = new ArrayList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("student_orders.xml");

            Node root = document.getDocumentElement();
            NodeList orderList = root.getChildNodes();
            for (int i = 0; i < orderList.getLength(); i++) {
                Node item = orderList.item(i);
                if (item instanceof Element) {
                    System.out.println(((Element) item).getAttribute("so-id"));
                    PersonAdult husband = new PersonAdult();
                    PersonAdult wife = new PersonAdult();
                    List<PersonChild> children = new ArrayList<>();

                    NodeList persons = item.getChildNodes();
                    for (int j = 0; j < persons.getLength(); j++) {
                        Node person = persons.item(j);
                        if (person instanceof Element) {
                            if ("husband".equals(person.getNodeName())) {
                                NodeList names = person.getChildNodes();
                                for (int k = 0; k < names.getLength(); k++) {
                                    Node name = names.item(k);
                                    if (name instanceof Element) {
                                        if ("surName".equals(name.getNodeName())) {
                                            husband.setSurName(name.getTextContent().trim());
                                        }
                                        if ("givenName".equals(name.getNodeName())) {
                                            husband.setGivenName(name.getTextContent());
                                        }
                                        if ("patronymic".equals(name.getNodeName())) {
                                            husband.setPatronymic(name.getTextContent());
                                        }
                                        if ("dateOfBirth".equals(name.getNodeName())) {
                                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                                            try {
                                                Date dob = sdf.parse(name.getTextContent());
                                                husband.setDateOfBirth(dob);
                                            } catch (ParseException pex) {
                                                pex.printStackTrace(System.out);
                                            }
                                        }
                                    }
                                }
                            }
                            if ("wife".equals(person.getNodeName())) {
                            }
                            if ("children".equals(person.getNodeName())) {
                            }
                        }
                    }
//                    StudentOrder so = new StudentOrder(husband, wife, children);
//                    soList.add(so);
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        for (StudentOrder so : soList) {
            System.out.println(so.getHusband().getDateOfBirth());
        }
    }
}
