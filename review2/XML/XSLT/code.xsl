<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/problems">
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

tr:hover  {background-color:#eeeeee;}
</style>
            </head>
            <body>
                <h1>Coding Problems</h1>
                <table border="2">
                    <tr>
                        <th>Problem Id</th>
                        <th>Problem Name</th>
                        <th>Problem Description</th>
                        <th>Difficulty</th>
                        <th>Faculty ID</th>
                    </tr>
                    <xsl:for-each select="problem">
                        <xsl:sort select="problemname" order="ascending" />
                            <xsl:choose>
                                <xsl:when test="problemdifficulty = 'Easy'">
                                    <tr bgcolor="#89beb3">
                                        <td>
                                            <xsl:value-of select="problemid" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="problemname" />
                                        </td>

                                        <td>
                                            <xsl:value-of select="problemdesc" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="problemdifficulty" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="facultyid" />
                                        </td>
                                    </tr>
                                </xsl:when>
                                <xsl:when test="problemdifficulty = 'Medium'">
                                    <tr bgcolor="#edc988">
                                        <td>
                                            <xsl:value-of select="problemid" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="problemname" />
                                        </td>

                                        <td>
                                            <xsl:value-of select="problemdesc" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="problemdifficulty" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="facultyid" />
                                        </td>
                                    </tr>
                                </xsl:when>
                                <xsl:when test="problemdifficulty = 'Difficult'">
                                    <tr bgcolor="#ff414d">
                                        <td>
                                            <xsl:value-of select="problemid" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="problemname" />
                                        </td>

                                        <td>
                                            <xsl:value-of select="problemdesc" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="problemdifficulty" />
                                        </td>
                                        <td>
                                            <xsl:value-of select="facultyid" />
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