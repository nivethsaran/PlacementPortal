<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/questions">
        <html>
            <head>
                <style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover  {background-color:#a6a6a4;}
</style>
            </head>
            <body>
                <h1>Questions</h1>
                <table border="2">
                    <tr>
                        <th>Quiz ID</th>
                        <th>Question ID</th>
                        <th>Question</th>
                        <th>Answer</th>
                        <th>Option A</th>
                        <th>Option B</th>
                        <th>Option C</th>
                        <th>Option D</th>
                        
                    </tr>
                    <xsl:for-each select="question">
                        <xsl:sort select="questionid" data-type="number" order="ascending" />
                        <xsl:choose>
                            <xsl:when test="answer = 'a'">
                                <tr bgcolor="#e8e8e8">
                                    <td>
                                        <xsl:value-of select="quizid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="questionid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="questioncontent" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="answer" />
                                    </td>
                                    <td bgcolor="#ccf6c8">
                                        <xsl:value-of select="optiona" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optionb" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optionc" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optiond" />
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:when test="answer = 'b'">
                                <tr bgcolor="#e8e8e8">
                                    <td>
                                        <xsl:value-of select="quizid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="questionid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="questioncontent" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="answer" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optiona" />
                                    </td>
                                    <td bgcolor="#ccf6c8">
                                        <xsl:value-of select="optionb" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optionc" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optiond" />
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:when test="answer = 'c'">
                                <tr bgcolor="#e8e8e8">
                                    <td>
                                        <xsl:value-of select="quizid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="questionid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="questioncontent" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="answer" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optiona" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optionb" />
                                    </td>
                                    <td bgcolor="#ccf6c8">
                                        <xsl:value-of select="optionc" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optiond" />
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:when test="answer = 'd'">
                                <tr bgcolor="#e8e8e8">
                                    <td>
                                        <xsl:value-of select="quizid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="questionid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="questioncontent" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="answer" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optiona" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optionb" />
                                    </td>
                                    <td bgcolor="#f56a79">
                                        <xsl:value-of select="optionc" />
                                    </td>
                                    <td bgcolor="#ccf6c8">
                                        <xsl:value-of select="optiond" />
                                    </td>
                                </tr>
                            </xsl:when>
                        </xsl:choose>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>