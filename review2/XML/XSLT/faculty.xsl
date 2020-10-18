<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/faculties">
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
                <h1>Faculties</h1>
                <table border="2">
                    <tr>
                        <th>Full Name</th>
                        <th>Faculty ID</th>
                        <th>Password</th>
                        <th>Profile Picture</th>
                        <th>Mobile</th>
                        <th>Email</th>
                        <th>Department</th>
                    </tr>
                    <xsl:for-each select="faculty">
                        <xsl:sort select="problemid" data-type="number" order="ascending" />
                        <tr bgcolor="#ee6f57">
                            <td>
                                <xsl:value-of select="fullname" />
                            </td>
                            <td>
                                <xsl:value-of select="facultyid" />
                            </td>

                            <td>
                                <xsl:value-of select="authpassword" />
                            </td>
                            <td>
                                <xsl:value-of select="avatarurl" />
                            </td>
                            <td>
                                <xsl:value-of select="mobilenumber" />
                            </td>
                            <td>
                                <xsl:value-of select="email" />
                            </td>
                            <td>
                                <xsl:value-of select="department" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>