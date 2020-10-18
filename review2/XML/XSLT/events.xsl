<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/events">
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
                <h1>Events</h1>
                <table border="2">
                    <tr>
                        <th>Event ID</th>
                        <th>Event Date</th>
                        <th>Event Title</th>
                        <th>Event Description</th>
                    </tr>
                    <xsl:for-each select="event">
                        <xsl:sort select="problemid" data-type="number" order="ascending" />
                        <tr bgcolor="#ee6f57">
                            <td>
                                <xsl:value-of select="eventid" />
                            </td>
                            <td>
                                <xsl:value-of select="eventdate" />
                            </td>

                            <td>
                                <xsl:value-of select="eventtitle" />
                            </td>
                            <td>
                                <xsl:value-of select="eventdesc" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>