<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/experiences">
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
                <h1>Placement Experience</h1>
                <table border="2">
                    <tr>
                        <th>Experience ID</th>
                        <th>Roll Number</th>
                        <th>Content</th>
                        <th>Company</th>
                        <th>Post Time</th>
                    </tr>
                    <xsl:for-each select="experience">
                        <xsl:sort select="experienceid" data-type="number" order="ascending" />
                        <tr bgcolor="#ee6f57">
                            <td>
                                <xsl:value-of select="experienceid" />
                            </td>
                            <td>
                                <xsl:value-of select="rollno" />
                            </td>
                            <td>
                                <xsl:value-of select="experiencecontent" />
                            </td>
                            <td>
                                <xsl:value-of select="companyname" />
                            </td>
                            <td>
                                <xsl:value-of select="posttime" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>