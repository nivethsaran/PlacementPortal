<%@ page import="models.Faculty" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Student" %><%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 20-11-2020
  Time: 08:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title> Preparely </title>
    <link rel="stylesheet" href="./contact/styles.css">

    <head>

<body>
<%
    String usertype = (String) request.getSession().getAttribute("usertype");
    String alphabet = (String) request.getAttribute("starting");
%>

<nav class="AlphabetNav">
    <a href="./">Back</a>
    <a href="./contact?alphabet=A" id="a">A</a>
    <a href="./contact?alphabet=B" id="b">B</a>
    <a href="./contact?alphabet=C" id="c">C</a>
    <a href="./contact?alphabet=D" id="d">D</a>
    <a href="./contact?alphabet=E" id="e">E</a>
    <a href="./contact?alphabet=F" id="f">F</a>
    <a href="./contact?alphabet=G" id="g">G</a>
    <a href="./contact?alphabet=H" id="h">H</a>
    <a href="./contact?alphabet=I" id="i">I</a>
    <a href="./contact?alphabet=J" id="j">J</a>
    <a href="./contact?alphabet=K" id="k">K</a>
    <a href="./contact?alphabet=L" id="l">L</a>
    <a href="./contact?alphabet=M" id="m">M</a>
    <a href="./contact?alphabet=N" id="n">N</a>
    <a href="./contact?alphabet=O" id="o">O</a>
    <a href="./contact?alphabet=P" id="p">P</a>
    <a href="./contact?alphabet=Q" id="q">Q</a>
    <a href="./contact?alphabet=R" id="r">R</a>
    <a href="./contact?alphabet=S" id="s">S</a>
    <a href="./contact?alphabet=T" id="t">T</a>
    <a href="./contact?alphabet=U" id="u">U</a>
    <a href="./contact?alphabet=V" id="v">V</a>
    <a href="./contact?alphabet=W" id="w">W</a>
    <a href="./contact?alphabet=X" id="x">X</a>
    <a href="./contact?alphabet=Y" id="y">Y</a>
    <a href="./contact?alphabet=Z" id="z">Z</a>
</nav>

<div class="ContactList" id="ContactList">
    <% if(usertype.equals("faculty"))
    {
        ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("contacts");
        for(Student i: students)
        {
            if(i.getFullname().charAt(0)==alphabet.charAt(0))
            {
                out.print("<section class=\"Contact\">\n" +
                        "            <img class=\"Contact-avatar\" src=\""+i.getAvatarurl()+"\" />\n" +
                        "            <h5 class=\"Contact-name\">"+i.getFullname()+"</h5>\n" +
                        "            <h3 class=\"Contact-name\">("+i.getEmail()+")</h3>\n" +
                        "            <h3 class=\"Contact-name\">("+i.getMobilenumber()+")</h3>\n" +
                        "        </section>");
            }
        }
    }
    else if(usertype.equals("student"))
    {
        ArrayList<Faculty> faculties = (ArrayList<Faculty>) request.getAttribute("contacts");
        for(Faculty i: faculties)
        {
            if(i.getFullname().charAt(0)==alphabet.charAt(0))
            {
                out.print("<section class=\"Contact\">\n" +
                        "            <img class=\"Contact-avatar\" src=\""+i.getAvatarurl()+"\" />\n" +
                        "            <h5 class=\"Contact-name\">"+i.getFullname()+"</h5>\n" +
                        "            <h3 class=\"Contact-name\">("+i.getEmail()+")</h3>\n" +
                        "            <h3 class=\"Contact-name\">("+i.getMobilenumber()+")</h3>\n" +
                        "        </section>");
            }
        }
    }
    %>
<%--    <section class="Contact">
            <img class="Contact-avatar" src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-80/newgirl-01.svg" />
            <h5 class="Contact-name">Amanda Smith</h5>
        </section>
--%>
</div>

<script src="./contact/script.js"></script>
</body>

</html>