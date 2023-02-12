import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TokenizeMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private final Text word = new Text();
    public static Log log= LogFactory.getLog(TokenizeMapper.class);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] valArr = value.toString().split(" ");
        for (String val : valArr) {
            word.set(val);
            log.info("word: " + word);
            log.info("one: " + one);
            /* emits a key-value pair of < <word>, 1>.
            Mapper 1
            < Hello, 1>
            < World, 1>
            < Bye, 1>
            < World, 1>

            */
            context.write(word, one);
        }
    }
}
