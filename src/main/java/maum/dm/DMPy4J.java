/*
 * Copyright 2016 (C) Inwoo Chung (gutomitai@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package maum.dm;

import org.apache.spark.api.java.JavaSparkContext;

import py4j.GatewayServer;

/**
 * <p> Entry class for DM libraries via Py4J. </p>

 * @author Inwoo Chung (gutomitai@gmail.com)
 * @since Sep. 9, 2016
 * 
 * <p> Revision: </p>
 * <ul>
 * 	<li>-Sep. 9, 2016 </br>
 * 		SparkNeuralNetwork is first added.
 * 	</li>
 * 	<li>-Sep. 13, 2016 </br>
 * 		Spark context is provided to use it globally.
 * 	</li>
 * </ul>
 */
public class DMPy4J {		
	
	/** Get a Spark Neural Network instance. */
	public SparkNeuralNetwork getSparkNeuralNetwork(JavaSparkContext sc, int numLayers, int[] numActs) {
		
		// Create and return an instance.
		return new SparkNeuralNetwork(sc, numLayers, numActs);
	}
		
	/** Get a Matrix instance. */
	public Matrix getMatrix(int rows, int cols, double val) {
		return new Matrix(rows, cols, val);
	}
	
	/** Get a Matrix instance. */
	public Matrix getMatrix(int rows, int cols, double[] vals) {
		return new Matrix(rows, cols, vals);
	}
	
	/** Main. */
	public static void main(String[] args) {
		GatewayServer gatewayServer = new GatewayServer(new DMPy4J());
		gatewayServer.start();
	}
}
