cd src;
echo 'Building';
javac *.java;
echo 'Running TicketSystemTester';
java TicketSystemTester
echo 'Running whole program with test input 1';
java HelpTickets < '../tests/inputs/input-1.txt' > '../tests/outputs/output-1.txt';
echo 'Diffing output with expected. Any changes will be shown below:'
diff -b '../tests/expected_outputs/output-1.txt' '../tests/outputs/output-1.txt';
echo 'Cleaning up';
rm -f *.class;
echo 'Done';
read -n 1 -s;