package ml;

import la.matrix.Matrix;
import la.vector.Vector;
import org.ejml.simple.SimpleMatrix;

/**
 * Created by Vilkas on 18/02/2017.
 */
public class ComputeCost {


    /**
     * computes the cost of using theta as the
     *  parameter for linear regression to fit the data points in X and
     *  octave formula J = (1/(2*m))*sum(power((X*theta - y),2))
     * @param trainingData  -> X
     * @param labels        -> y
     * @param theta         -> theta
     * @return
     */
    public static double computeCost(SimpleMatrix trainingData, SimpleMatrix labels, SimpleMatrix theta) {
        SimpleMatrix hypothesis = trainingData.mult(theta);
        SimpleMatrix errors = hypothesis.minus(labels);
        SimpleMatrix sqrErrors = errors.elementPower(2);
        double sum = sqrErrors.elementSum();
        int m = labels.getMatrix().numRows; // number of training examples
        double divider = 2*m;
        double j = sum* (1 /divider);
        return j;
    }

}
