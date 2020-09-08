cd ..

echo "Building the project..."
mvn clean compile assembly:single

echo "Starting execution of test runs. Please be patient, this may take a while."

echo "Test run 1 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_1.stat -p seed.0=1692274249 -p seed.1=1692274250 -p seed.2=1692274251 -p seed.3=1692274252) 2> results/run_1.logs

echo "Test run 2 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_2.stat -p seed.0=1690354059 -p seed.1=1690354060 -p seed.2=1690354061 -p seed.3=1690354062) 2> results/run_2.logs

echo "Test run 3 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_3.stat -p seed.0=1690531819 -p seed.1=1690531820 -p seed.2=1690531821 -p seed.3=1690531822) 2> results/run_3.logs

echo "Test run 4 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_4.stat -p seed.0=1690703721 -p seed.1=1690703722 -p seed.2=1690703723 -p seed.3=1690703724) 2> results/run_4.logs

echo "Test run 5 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_5.stat -p seed.0=1690848693 -p seed.1=1690848694 -p seed.2=1690848695 -p seed.3=1690848696) 2> results/run_5.logs

echo "Test run 6 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_6.stat -p seed.0=1690954054 -p seed.1=1690954055 -p seed.2=1690954056 -p seed.3=1690954057) 2> results/run_6.logs

echo "Test run 7 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_7.stat -p seed.0=1691093254 -p seed.1=1691093255 -p seed.2=1691093256 -p seed.3=1691093257) 2> results/run_7.logs

echo "Test run 8 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_8.stat -p seed.0=1691204904 -p seed.1=1691204905 -p seed.2=1691204906 -p seed.3=1691204907) 2> results/run_8.logs

echo "Test run 9 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_9.stat -p seed.0=1691563204 -p seed.1=1691563205 -p seed.2=1691563206 -p seed.3=1691563207) 2> results/run_9.logs

echo "Test run 10 executing..."
(time java -jar target/cos_710_assignment_1-1.0-SNAPSHOT-jar-with-dependencies.jar -file src/main/resources/ecj/custom.params -p gp.tree.print-style=latex -p stat.file=\$results/run_10.stat -p seed.0=1692426574 -p seed.1=1692426575 -p seed.2=1692426576 -p seed.3=1692426577) 2> results/run_10.logs