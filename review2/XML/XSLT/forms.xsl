<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/forms">
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
                <h1>Company Forms</h1>
                <table border="2">
                    <tr>
                        <th>Faculty ID</th>
                        <th>Form ID</th>
                        <th>Company Name</th>
                        <th>Deadline</th>
                        <th>Form URL</th>
                    </tr>
                    <xsl:for-each select="form">
                        <xsl:sort select="problemid" data-type="number" order="ascending" />
                        <tr bgcolor="#ee6f57">
                            <td>
                                <xsl:value-of select="facultyid" />
                            </td>
                            <td>
                                <xsl:value-of select="formid" />
                            </td>

                            <td>
                                <xsl:value-of select="companyname" />
                            </td>
                            <td>
                                <xsl:value-of select="deadline" />
                            </td>
                            <td>
                                <xsl:value-of select="formurl" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>