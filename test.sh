cd src;
echo 'Building';
javac *.java;
echo 'Running';
java TicketSystemTester
echo 'Cleaning up';
rm -f *.class;
echo 'Done';