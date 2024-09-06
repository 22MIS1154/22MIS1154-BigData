import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GradeMapper extends Mapper<Object, Text, Text, IntWritable> {

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] studentData = value.toString().split(" ");
        String studentName = studentData[0];
        int grade = Integer.parseInt(studentData[1]);

        // If the student's grade is above 60, emit the name and grade
        if (grade > 60) {
            context.write(new Text(studentName), new IntWritable(grade));
        }
    }
}