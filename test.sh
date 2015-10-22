cd src;
echo 'Running';
java HelpTickets < ../tests/inputs/input-1.txt > ../tests/outputs/output-1.txt;
echo 'Finished';
echo 'Diffing expected output';
diff '../tests/outputs/output-1.txt' '../tests/expected_outputs/output-1.txt';
echo 'Done';