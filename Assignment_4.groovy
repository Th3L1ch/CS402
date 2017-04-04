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

def xmlData = new XmlParser().parse('Bus_Timetable.xml')
def columns = xmlData.'**'*.name
def traincodes = columns.count {it.contains("tag0:Traincode")}
//def traincodes = columns.count {it.contains("Traincode")}
println traincodes
//def xmlData = traincodes
//println counter

if(traincodes == 0)
{
	markup.html{
        head {
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
	def rowCount = traincodes
	
	markup.html{
		table(style: 'border:1px solid;text-align:center;') {
			tr {
				th()
				columns.each { title -> th(title)}
			}
			(1..rowCount).each { row ->
				tr(style: 'border:1px solid;text-align:center;') {
					td(style: 'border:1px solid;text-align:center;',row)
					columns.each { td(columns.text()) }
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