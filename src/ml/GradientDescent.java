package ml;

import org.ejml.simple.SimpleMatrix;

/**
 * Created by Vilkas on 19/02/2017.
 */
public class GradientDescent {


    /**
     *   it Performs gradient descent to learn theta
     *   theta = GRADIENTDESENT(X, y, theta, alpha, num_iters) updates theta by
     *   taking num_iters gradient steps with learning rate alpha
     * Octave Formula =  theta = theta - (alpha/m) * (X' * (X * theta - y));
     * @param trainingData          -> X
     * @param labels                -> y
     * @param theta                 -> theta
     * @param alpha                 -> alpha (step size modifier)
     * @param numberOfIterations    -> number of iterations
     * @return
     */
    public static SimpleMatrix gradientDescent(SimpleMatrix trainingData, SimpleMatrix labels, SimpleMatrix theta, double alpha, int numberOfIterations) {
        int m = labels.numRows();
        double jImprovement = 0;
        double oldJ = 0;
        double currentJ = 0;
        for (int i=0;i<numberOfIterations;i++){
            SimpleMatrix mult1 = trainingData.mult(theta);
            SimpleMatrix sub = mult1.minus(labels);
            SimpleMatrix transMult = trainingData.transpose().mult(sub);
            SimpleMatrix mult2 = transMult.scale(alpha/m);
            theta = theta.minus(mult2);
//             this prints the improvements of process.
//             feel free to decomment this and check the steps.(first iteration is kinda useles :)
//            oldJ = currentJ;
//            currentJ = ComputeCost.computeCost(trainingData, labels, theta);
//            jImprovement = oldJ-currentJ;
//            System.out.print("iteration nr :"+i+" J="+ currentJ);
//            System.out.println("  JImprovement = "+ (jImprovement));

        }

        return theta;
    }
}
