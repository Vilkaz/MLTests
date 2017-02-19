import ml.GradientDescent;
import org.ejml.simple.SimpleMatrix;

/**
 * Created by Vilkas on 18/02/2017.
 */
public class GradientDescentPlayground {

    public static void main(String[] args) {
        SimpleMatrix trainingData = new SimpleMatrix(50, 2);
        SimpleMatrix labels = new SimpleMatrix(50, 1);
        SimpleMatrix theta = new SimpleMatrix(2, 1);
        theta.set(0,0);
        theta.set(1,0);
        System.out.println(theta.elementSum());
        for (int i=0;i<labels.numRows();i++){
            trainingData.set(i,0,1);
            trainingData.set(i,1,i);
            labels.set(i,0,12+(i*13));
        }
        /**
         * if alpha is bigger then 0.001, we cant converge.
         */
        double alpha = 0.001;
        int numberOfIterations = 50000;
        SimpleMatrix optimum =  GradientDescent.gradientDescent(trainingData, labels, theta, alpha,numberOfIterations );
        System.out.println(optimum);
    }
}
