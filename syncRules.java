
 
 ===================================== example ===========================
 
 def hobbyMap = ["Futbol": "Soccer", "Beisbol": "Baseball"] // ["remote options" : "local option"]
 
def remoteHobby = replica.customFields."Hobby"?.value?.value

issue.customFields."Hobby".value = hobbyMap[remoteHobby] ?: remoteHobby

 ===================================== example ===========================

 ++++++++++++++++ Jira Outgoing:-

replica.Waiting_for = issue.customFields."Pending Reason" 


+++++++++++++++++ SNow Incoming:-


log.info"##SelectList1- ${replica.Waiting_for}"

if(	replica.Waiting_for.value.toString().equals("Inputs from requestor"))
	entity.Waiting_for = "Problem Resolution"
	
	
+++++++++++++++++ SNow Outgoing:-

replica.Waiting_for = entity.Waiting_for


+++++++++++++++++ Jira Incoming:-

log.info"##SelectList1- ${replica.Waiting_for}"


 
 
 
 
 
