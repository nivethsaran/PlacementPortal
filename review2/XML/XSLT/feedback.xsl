<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/feedbacks">
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
                <h1>Faculty Feedback</h1>
                <table border="2">
                    <tr>
                        <th>Faculty ID</th>
                        <th>Feedback ID</th>
                        <th>Pace</th>
                        <th>Online tool usage</th>
                        <th>Effectiveness</th>
                        <th>Approachability</th>
                        <th>Would you recommend course?</th>
                        <th>Opt for a adv course in future?</th>
                        <th>Suggestions</th>
                        <th>Course ID</th>
                    </tr>
                    <xsl:for-each select="feedback">
                        <xsl:sort select="problemid" data-type="number" order="ascending" />
                        <tr bgcolor="#ee6f57">
                            <td>
                                <xsl:value-of select="facultyid" />
                            </td>
                            <td>
                                <xsl:value-of select="feedbackid" />
                            </td>

                            <td>
                                <xsl:value-of select="pace" />
                            </td>
                            <td>
                                <xsl:value-of select="onlinetoolsusgae" />
                            </td>
                            <td>
                                <xsl:value-of select="effectiveness" />
                            </td>
                            <td>
                                <xsl:value-of select="approachability" />
                            </td>
                            <td>
                                <xsl:value-of select="recommend" />
                            </td>
                            <td>
                                <xsl:value-of select="optadvanced" />
                            </td>
                            <td>
                                <xsl:value-of select="suggestions" />
                            </td>
                            <td>
                                <xsl:value-of select="courseid" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>