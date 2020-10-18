<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/notes">
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
                <h1>Notes</h1>
                <table border="2">
                    <tr>
                        <th>Note ID</th>
                        <th>Note Title</th>
                        <th>Content</th>
                        <th>Date</th>
                        <th>Roll Number</th>
                    </tr>
                    <xsl:for-each select="note">
                        <xsl:sort select="noteid" data-type="number" order="ascending" />
                        <tr bgcolor="#ee6f57">
                            <td>
                                <xsl:value-of select="noteid" />
                            </td>
                            <td>
                                <xsl:value-of select="notetitle" />
                            </td>
                            <td>
                                <xsl:value-of select="notecontent" />
                            </td>
                            <td>
                                <xsl:value-of select="notedate" />
                            </td>
                            <td>
                                <xsl:value-of select="rollno" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>