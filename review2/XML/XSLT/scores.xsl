<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/scores">
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

tr:hover  {background-color:#ffa5a5;}
</style>
            </head>
            <body>
                <h1>Scores</h1>
                <table border="2">
                    <tr>
                        <th>Score ID</th>
                        <th>Quiz ID</th>
                        <th>Roll Number</th>
                        <th>Total</th>
                        <th>Score</th>
                    </tr>
                    <xsl:for-each select="score">
                        <xsl:sort select="scoreid" data-type="number" order="ascending" />
                        <tr bgcolor="#ee6f57">
                            <td>
                                <xsl:value-of select="scoreid" />
                            </td>
                            <td>
                                <xsl:value-of select="quizid" />
                            </td>
                            <td>
                                <xsl:value-of select="rollno" />
                            </td>
                            <td>
                                <xsl:value-of select="total" />
                            </td>
                            <td>
                                <xsl:value-of select="studentscore" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>