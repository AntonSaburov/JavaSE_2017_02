package edu.javacourse.third.db;


import edu.javacourse.third.domain.PersonAdult;
import edu.javacourse.third.domain.StudentOrder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by antonsaburov on 20.03.17.
 */
public class XmlPathDataSource implements StudentOrderDataSource
{
    @Override
    public List<StudentOrder> getStudentOrders() {
        return null;
    }

    public static void main(String[] args) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("student_orders.xml");

            Node root = document.getDocumentElement();

//            extractOrders(root);

            List<Integer> ids = extractOrdersId(root);
            for (Integer id : ids) {
                PersonAdult wife = getWife(root, id);
                System.out.println(wife.getDateOfBirth());
                System.out.println(wife.getSurName());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

    }

    private static void extractOrders(Node root) throws XPathExpressionException {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();

        XPathExpression expr = xpath.compile("student-order");
        NodeList nodes = (NodeList) expr.evaluate(root, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            System.out.println(n.getNodeName());
        }
    }

    private static List<Integer> extractOrdersId(Node root) throws XPathExpressionException {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();

        List<Integer> result = new ArrayList<>();
        XPathExpression expr = xpath.compile("student-order");
        NodeList nodes = (NodeList) expr.evaluate(root, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            int id = Integer.parseInt(((Element) n).getAttribute("so-id"));
            result.add(id);
        }
        return result;
    }

    private static PersonAdult getWife(Node root, Integer id) throws XPathExpressionException {
        PersonAdult person = new PersonAdult();

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();
        String g = String.format("student-order[@so-id='%d']/wife", id);
        XPathExpression expr = xpath.compile(g);
        Node node = (Node) expr.evaluate(root, XPathConstants.NODE);
        NodeList names = node.getChildNodes();
        for (int k = 0; k < names.getLength(); k++) {
            Node name = names.item(k);
            if (name instanceof Element) {
                if ("surName".equals(name.getNodeName())) {
                    person.setSurName(name.getTextContent().trim());
                }
                if ("givenName".equals(name.getNodeName())) {
                    person.setGivenName(name.getTextContent());
                }
                if ("patronymic".equals(name.getNodeName())) {
                    person.setPatronymic(name.getTextContent());
                }
                if ("dateOfBirth".equals(name.getNodeName())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        Date dob = sdf.parse(name.getTextContent());
                        person.setDateOfBirth(dob);
                    } catch (ParseException pex) {
                        pex.printStackTrace(System.out);
                    }
                }
            }
        }
        return person;
    }

}
