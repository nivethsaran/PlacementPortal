<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/courses">
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
                <h1>Course List</h1>
                <table border="2">
                    <tr>
                        <th>Course Id</th>
                        <th>Course Name</th>
                        <th>Topic</th>
                        <th>Department</th>
                        <th>CourseURL</th>
                        <th>Faculty ID</th>
                    </tr>
                    <xsl:for-each select="course">
                        <xsl:sort select="problemid" data-type="number" order="ascending" />
                        <tr bgcolor="#ee6f57">
                            <td>
                                <xsl:value-of select="courseid" />
                            </td>
                            <td>
                                <xsl:value-of select="coursename" />
                            </td>

                            <td>
                                <xsl:value-of select="topicname" />
                            </td>
                            <td>
                                <xsl:value-of select="department" />
                            </td>
                            <td>
                                <xsl:value-of select="courseurl" />
                            </td>
                            <td>
                                <xsl:value-of select="facultyid" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>