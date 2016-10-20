rm -rf ./tmp/
git clone https://github.com/WhisperSystems/libsignal-service-java.git tmp
javadoc -doclet com.google.doclava.Doclava -docletpath doclava-1.0.6.jar -d . -sourcepath tmp/java/src/main/java/ -subpackages org -hdf project.name "libsignal-service-java"
rm -rf ./tmp/
