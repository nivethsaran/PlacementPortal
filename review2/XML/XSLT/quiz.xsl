<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/quizzes">
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
                <h1>Quiz</h1>
                <table border="2">
                    <tr>
                        <th>Quiz ID</th>
                        <th>Faculty ID</th>
                        <th>Quiz Name</th>
                        <th>Description</th>
                        <th>Number of Questions</th>
                        <th>Date</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Duration</th>
                        <th>Department</th>
                        <th>Topic</th>
                        <th>PIN</th>
                    </tr>
                    <xsl:for-each select="quiz">
                        <!-- <xsl:sort select="date" data-type="number" order="descending" /> -->
                        <xsl:sort select="duration" data-type="number" order="ascending" />
                        <xsl:choose>
                            <xsl:when test="department = 'CSE'">
                                <tr class="CSE" bgcolor="#bedbbb">
                                    <td>
                                        <xsl:value-of select="quizid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="facultyid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizname" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizdescription" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="numofquestions" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizdate" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizstarttime" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizendtime" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="duration" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="department" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="topic" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="pin" />
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:when test="department = 'NONCSE'">
                                <tr class="NONCSE" bgcolor="#f5a25d">
                                    <td>
                                        <xsl:value-of select="quizid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="facultyid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizname" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizdescription" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="numofquestions" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizdate" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizstarttime" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizendtime" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="duration" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="department" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="topic" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="pin" />
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:when class="ALL" test="department = 'ALL'">
                                <tr bgcolor="#f8efd4">
                                    <td>
                                        <xsl:value-of select="quizid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="facultyid" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizname" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizdescription" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="numofquestions" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizdate" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizstarttime" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="quizendtime" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="duration" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="department" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="topic" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="pin" />
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