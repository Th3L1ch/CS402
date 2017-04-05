import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

print "This is a program to get the contents of an xml document hosted at a url and return the data, neatly parsed.\n"

// Load html file containing xml data

// def url = "https://data.dublinked.ie/cgi-bin/rtpi/realtimebusinformation?stopid=103381&format=xml"
def url = "http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByCodeXML?StationCode=ENFLD"
def html = new XmlSlurper().parse(url)

// Function to format the xml nicely

def streamingMarkupBuilder = new StreamingMarkupBuilder()
// Print the xml text data to ensure we're getting the correct output

xmldata = XmlUtil.serialize(streamingMarkupBuilder.bind{mkp.yield html})
println xmldata

def writer = new FileWriter('Bus_Timetable.xml')
XmlUtil.serialize(xmldata, writer)

def writer2 = new StringWriter()  // html is written here by markup builder
def markup = new groovy.xml.MarkupBuilder(writer2)  // the builder

def xmlDat2 = new XmlSlurper().parse('Bus_Timetable.xml')
//def xmlDat2 = new XmlSlurper().parse('testFile.xml')	//For testing
def columns = ['Traincode','Querytime','Traindate','Origin','Destination','Status','Due in','Scheduled depart']

def Traincodes = xmlDat2.depthFirst().findAll { it.name() == 'Traincode' }
def Querytimes = xmlDat2.depthFirst().findAll { it.name() == 'Querytime' }
def Traindates = xmlDat2.depthFirst().findAll { it.name() == 'Traindate' }
def Origins = xmlDat2.depthFirst().findAll { it.name() == 'Origin' }
def Destinations = xmlDat2.depthFirst().findAll { it.name() == 'Destination' }
def Statuses = xmlDat2.depthFirst().findAll { it.name() == 'Status' }
def Dueins = xmlDat2.depthFirst().findAll { it.name() == 'Duein' }
def Schdeparts = xmlDat2.depthFirst().findAll { it.name() == 'Schdepart' }
println Traincodes

if(Traincodes.size() == 0)
{
	markup.html{
        head {
			style(type:"text/css", '''
			.bigPaddingAndGreen {
				margin: 30px;
				padding: 30px;
				background-color: #00FF00
			}
			''')
            title: "Current trainstation data"
        }
        body(id: "main") {
            p {
                mkp.yield "There are currently no trains arriving at Enfield station."
            }
			br{}
			p {
				mkp.yield "Please Try again later."
            }
            img src: "http://stream1.gifsoup.com/view6/20140921/5111813/camera-narrowly-avoids-oncoming-train-o.gif"
        }
	}
}
else
{
	def rowCount = Traincodes.size()
	
	markup.html{
		head {
			style(type:"text/css", '''
			.bigPaddingAndGreen {
				margin: 30px;
				padding: 30px;
				background-color: #00FF00
			}
			''')
            title: "Current trainstation data"
        }
		body(id: "main") {
			table(style: 'border:1px solid;text-align:center;') {
				tr {
					columns.each { title -> th(title)}
				}
				(1..rowCount).each { row ->
					tr(style: 'border:1px solid;text-align:center;') {
						Traincodes[row-1].each { title -> td(title) }
						Querytimes[row-1].each { title -> td(title) }
						Traindates[row-1].each { title -> td(title) }
						Origins[row-1].each { title -> td(title) }
						Destinations[row-1].each { title -> td(title) }
						Statuses[row-1].each { title -> td(title) }
						Dueins[row-1].each { title -> td(title) }
						Schdeparts[row-1].each { title -> td(title) }
					}
				}
			}
		}
	}
}

def htmlText = writer2.toString()
def file1 = new File('Bus_Timetable.html')
file1.write htmlText

//	run batch.script
//		run g.script
//		generate html.file
//		open html in browser.
