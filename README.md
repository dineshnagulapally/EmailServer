Steps:

1. Enable 2- step authentication in gmail
Google Account -> Security -> 2-Step Verification -> Input password as asked -> Turn ON (you could use SMS to get Gmail code to activate 2-Step Verification)
Google Account -> Security -> App password -> Input password as asked -> Select the app and device... -> e.g. Other(Custom name) -> Input app name e.g. MyApp -> Generate
Copy a 16-character password
Use a 16-character password with Gmail username in your application  (ex: PasswordAuthentication(from, replace your 16 char pwd here in quotes);)

2. change the address of your resume in controller file

attachPart.attachFile("C:\\Users\\dines\\Desktop\\Dinesh_Resume.pdf"); //replace your resume location
change the email subject and body also.

3.install postman application and sign with any of your google account

go to my work space. 
select Body and choose raw and select JSON from drop down menu.
SELECT POST as method and provide url as http://localhost:8080/sendemail

in the body: 
copy content as below
{
    "from" : "dineshnagulapelly@gmail.com",
    "to" : [all email ids comma seperated],
     "name" : [corresponding names for above email comma seperated]
}
