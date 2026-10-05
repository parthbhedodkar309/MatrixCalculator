import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class matrixass {
	
	
	public static void main(String[] args) {

		 Map<Integer , matricesdata> allmatricesid = new HashMap<Integer , matricesdata>();
		  ArrayList<matricesdata> allmatrices = new ArrayList<matricesdata>();
		int repeat = 1;
		int matrixcount=0;
		int determinant = -1;
		while(repeat==1) {
		Scanner sc = new Scanner(System.in);
        Random rd = new Random();
		System.out.println("\nMatrix Calculator initialised");
		System.out.println(""
				+ "1. Taking input of a matrix \n"
				+ "2. Making a new Matrix of requested type \n"
				+ "3. Changing the elements of matrix \n"
				+ "4. Display the labels of a matrix \n"
				+ "5. Perform addition subtraction and division \n"
				+ "6. Perform element-wise operations \n"
				+ "7. Transpose matrix \n"
				+ "8. Inverse matrix \n"
				+ "9. Compute mean \n"
				+ "10. Compute determinants \n"
				+ "11. Use singleton matrix as scalars \n"
				+ "12. Compute A + A^T for a matrix \n"
				+ "13. Computer Eigen values and vectors \n"
				+ "14. Solve sets of linear equations using matrices \n"
				+ "15. Retrieve all the existing matrices , having certain labels \n");
		int choice = sc.nextInt();
		if (choice ==1 ) {
			System.out.println("Take input of the matrix");
			System.out.println("Enter the number of rows of the matrix to be added");
			int row1 = sc.nextInt();
			System.out.println("Enter the number of columns of the matrix to be added");
			int col1 = sc.nextInt();
			int[][] matrix1 = new int[row1][col1];
			///Taking input of matrix 1
			for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	            	System.out.print("Enter the element of row "+(i+1)+", column "+(j+1)+"\n");
	                matrix1[i][j] = sc.nextInt();
	            }
	        }
			
			/*if (row1==col1) {
	            if(row1==1) {
	                determinant=matrix1[0][0];
	            }
	            if (row1==2) {
	                determinant = (matrix1[0][0]*matrix1[1][1])-(matrix1[1][0]*matrix1[0][1])  ;
	            }
	            if(row1==3){
	                determinant = ( matrix1[0][0]*(matrix1[1][1]*matrix1[2][2] -matrix1[2][1]*matrix1[1][2] ) - matrix1[0][1]*( matrix1[1][0]*matrix1[2][2] - matrix1[2][0]*matrix1[1][2] )  + matrix1[0][2]*( matrix1[1][0]*matrix1[2][1] - matrix1[2][0]*matrix1[1][1]     )      );       
	            }
	        }*/
			List<String> newlabels = new ArrayList<String>();
            ////
            //Matrix types
	        if (row1 != col1) {
	        	newlabels.add("Rectangular Matrix");
	        }
	        if(row1==1) {
	        	newlabels.add("Row Matrix ");
	        }
	        if(col1 ==1) {
	        	newlabels.add("Column Matrix");
	        }
	        if (row1 ==col1) {
	        	newlabels.add("Square Matrix");
	        }
            ////
            //Symmetric Matrix
	        if (row1 == col1) {
	        	if (row1 == 1) {
	        		newlabels.add("Symmetric Matrix");     //Symmetric matrix for 1x1
	        	}
	        	if (row1 == 2) {
	        		if( matrix1[1][0] == matrix1[0][1]  ) {
	        			newlabels.add("Symmetric Matrix");          //Symmetric matrix for 2x2
	        		}
	        	}
	        	if(row1 == 3) {
	        		if( matrix1[1][2]== matrix1[2][1] ) {
	        			if(matrix1[1][0] == matrix1[0][1]  ) {
	        				if( matrix1[2][0] == matrix1[0][2]  ) {
	        					newlabels.add("Symmetric Matrix");       //Symmetric matrix for 3x3
	        					
	        				}
	        			}
	        		}
	        	}
	        	
	        }
            //Skew-Symmetric Matrix
            if (row1 == col1) {
	        	if (row1 == 1) {
	        		newlabels.add("Skew Symmetric Matrix");     //Symmetric matrix for 1x1
	        	}
	        	if (row1 == 2) {
	        		if( matrix1[1][0] == (-1)*matrix1[0][1]  ) {
	        			newlabels.add("Skew Symmetric Matrix");          //Symmetric matrix for 2x2
	        		}
	        	}
	        	if(row1 == 3) {
	        		if( matrix1[1][2]== (-1)*matrix1[2][1] ) {
	        			if(matrix1[1][0] ==(-1)* matrix1[0][1]  ) {
	        				if( matrix1[2][0] == (-1)*matrix1[0][2]  ) {
	        					newlabels.add("Skew Symmetric Matrix");       //Symmetric matrix for 3x3
	        					
	        				}
	        			}
	        		}
	        	}
	        	
	        }
            //Upper-Triangular matrix
            if(row1==col1){
                if(row1==2){
                    if ( matrix1[1][0]==0 ){
                        newlabels.add("Upper Triangular");
                    }
                }
                if(row1==3){
                    if(matrix1[1][0]==0 && matrix1[2][0]==0 && matrix1[2][1]==0 ){
                        newlabels.add("Upper Triangular");
                    }
                }
            }
            //Lower-Triangular matrix
            if(row1==col1){
                if(row1==2){
                    if ( matrix1[0][1]==0 ){
                        newlabels.add("Lower Triangular");
                    }
                }
                if(row1==3){
                    if(matrix1[0][1]==0 && matrix1[0][2]==0 && matrix1[1][2]==0 ){
                        newlabels.add("Lower Triangular");
                    }
                }
            }
            ////
            //Singular Matrix
            if(row1==col1){
                if (row1==col1) {
                    if(row1==1) {
                        determinant=matrix1[0][0];
                    }
                    if (row1==2) {
                        determinant = (matrix1[0][0]*matrix1[1][1])-(matrix1[1][0]*matrix1[0][1])  ;
                    }
                    if(row1==3){
                        determinant = ( matrix1[0][0]*(matrix1[1][1]*matrix1[2][2] -matrix1[2][1]*matrix1[1][2] ) - matrix1[0][1]*( matrix1[1][0]*matrix1[2][2] - matrix1[2][0]*matrix1[1][2] )  + matrix1[0][2]*( matrix1[1][0]*matrix1[2][1] - matrix1[2][0]*matrix1[1][1]     )      );       
                    }
                }
                if(determinant ==0){
                    newlabels.add("Singular Matrix");
                }
            }
            ///
            //Diagonal Matrix
            if(row1 == col1){
                if (row1==1){
                    newlabels.add("Diagonal Matrix");
                }
                if(row1==2){
                    if( matrix1[1][0]==0 && matrix1[0][1]==0  ){
                        newlabels.add("Diagonal Matrix");
                    }
                }
                if(row1==3){
                    if( matrix1[0][1]==0 && matrix1[0][2]==0 && matrix1[1][2]==0 && matrix1[1][0]==0 && matrix1[2][0]==0 && matrix1[2][1]==0 ){
                        newlabels.add("Diagonal Matrix");
                    }
                }
            } 
            ///
            //Scalar Matrix
            if(row1 == col1){
                if (row1==1){
                    newlabels.add("Scalar Matrix");
                }
                if(row1==2){
                    if( matrix1[1][0]==0 && matrix1[0][1]==0  ){
                        if(matrix1[0][0]==matrix1[1][1]){
                            newlabels.add("Scalar Matrix");
                        }
                    }
                }
                if(row1==3){
                    if( matrix1[0][1]==0 && matrix1[0][2]==0 && matrix1[1][2]==0 && matrix1[1][0]==0 && matrix1[2][0]==0 && matrix1[2][1]==0 ){
                        if(matrix1[0][0]==matrix1[1][1] && matrix1[1][1]== matrix1[2][2]){
                            newlabels.add("Scalar Matrix");
                        }
                    }
                }
            } 
            ///
            //Identity matrix
            if(row1 == col1){
                if (row1==1){
                    if (matrix1[0][0]==1){
                        newlabels.add("Identity Matrix");
                    }
                }
                if(row1==2){
                    if( matrix1[1][0]==0 && matrix1[0][1]==0  ){
                        if(matrix1[0][0]==matrix1[1][1]){
                            if (matrix1[0][0]==1){
                                newlabels.add("Identity Matrix");
                            }
                        }
                    }
                }
                if(row1==3){
                    if( matrix1[0][1]==0 && matrix1[0][2]==0 && matrix1[1][2]==0 && matrix1[1][0]==0 && matrix1[2][0]==0 && matrix1[2][1]==0 ){
                        if(matrix1[0][0]==matrix1[1][1] && matrix1[1][1]== matrix1[2][2]){
                            if (matrix1[0][0]==1){
                                newlabels.add("identity Matrix");
                            }
                        }
                    }
                }
            } 
            ///
            //Singleton Matrix
            if (row1==1 && col1==1){
                newlabels.add("Singleton Matrix");
            }
            ///
            //Ones matrix
            newlabels.add("Ones Matrix");
            for(int i=0 ; i<row1 ; i++){
                for (int j=0 ; j<col1 ; j++){
                    if (matrix1[i][j]!=1){
                        newlabels.remove("Ones Matrix");
                    }
                }
            }
            
            ///
            //Null Matrix
            newlabels.add("Null Matrix");
            for(int i=0 ; i<row1 ; i++){
                for (int j=0 ; j<col1 ; j++){
                    if (matrix1[i][j]!=0){
                        newlabels.remove("Null Matrix");
                    }
                }
            }
            ///

			matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 ,  newlabels , matrixcount);
			System.out.println("The id of this matrix is "+matrixcount);
			allmatricesid.put(matrixcount , newmatrix1);
			allmatrices.add(newmatrix1);
            matrixcount = matrixcount+1;
            
		}

        if(choice==2){
            //Creating Matrix from labels
            System.out.println("1. Rectangular Matrix\n"
            +"2. Row Matrix\n"
            +"3. Column Matrix\n"
            +"4. Square Matrix\n"
            +"5. Symmetric Matrix\n"
            +"6. Skew-Symmetric Matrix\n"
            +"7. Upper-triangular Matrix\n"
            +"8. Lower-triangular Matrix\n"
            +"9. Singular Matrix\n"
            +"10. Diagonal Matrix\n"
            +"11. Scalar Matrix\n"
            +"12. Identity Matrix\n"
            +"13. Singleton Matrix\n"
            +"14. Ones Matrix\n"
            +"15. Null Matrix\n");
            System.out.println("Choose the id of required matrix type");
            int idchoice = sc.nextInt();
            if (idchoice ==1){
                System.out.println("You have selected Rectangular Matrix ");
                System.out.println("Enter the number of rows");
                int row1 =sc.nextInt();
                System.out.println("Enter the number of columns");
                int col1 = sc.nextInt();
                System.out.println("Your matrix is");
                int[][] matrix1 = new int[row1][col1];
                ///Taking input of matrix 1
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {

                        matrix1[i][j] = rd.nextInt(40)+3;
                    }
                }
                
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                if (row1==col1) {
                    if(row1==1) {
                        determinant=matrix1[0][0];
                    }
                    if (row1==2) {
                        determinant = (matrix1[0][0]*matrix1[1][1])-(matrix1[1][0]*matrix1[0][1])  ;
                    }
                    if(row1==3){
                        determinant = ( matrix1[0][0]*(matrix1[1][1]*matrix1[2][2] -matrix1[2][1]*matrix1[1][2] ) - matrix1[0][1]*( matrix1[1][0]*matrix1[2][2] - matrix1[2][0]*matrix1[1][2] )  + matrix1[0][2]*( matrix1[1][0]*matrix1[2][1] - matrix1[2][0]*matrix1[1][1]     )      );       
                    }
                }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Rectangular Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 ,  newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==2){
                //Row matrix
                System.out.println("You have selected Row Matrix ");
                int row1=1;
                System.out.println("Enter the number of columns");
                int col1 = sc.nextInt();
                System.out.println("Your matrix is ");
                int[][] matrix1 = new int[row1][col1];
                ///Taking input of matrix 1
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {

                        matrix1[i][j] = rd.nextInt(40)+3;
                    }
                }
                
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                if (row1==col1) {
                    if(row1==1) {
                        determinant=matrix1[0][0];
                    }
                    if (row1==2) {
                        determinant = (matrix1[0][0]*matrix1[1][1])-(matrix1[1][0]*matrix1[0][1])  ;
                    }
                    if(row1==3){
                        determinant = ( matrix1[0][0]*(matrix1[1][1]*matrix1[2][2] -matrix1[2][1]*matrix1[1][2] ) - matrix1[0][1]*( matrix1[1][0]*matrix1[2][2] - matrix1[2][0]*matrix1[1][2] )  + matrix1[0][2]*( matrix1[1][0]*matrix1[2][1] - matrix1[2][0]*matrix1[1][1]     )      );       
                    }
                }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Row Matrix");
                newlabels.add("Rectangular Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 ,   newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;

            }
            if(idchoice==3){
                //Row matrix
                System.out.println("You have selected Column Matrix ");
                System.out.println("Enter the number of rows");
                int row1=sc.nextInt();
                int col1 = 1;
                int[][] matrix1 = new int[row1][col1];
                ///Taking input of matrix 1
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {

                        matrix1[i][j] = rd.nextInt(40)+3;
                    }
                }
                
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                if (row1==col1) {
                    if(row1==1) {
                        determinant=matrix1[0][0];
                    }
                    if (row1==2) {
                        determinant = (matrix1[0][0]*matrix1[1][1])-(matrix1[1][0]*matrix1[0][1])  ;
                    }
                    if(row1==3){
                        determinant = ( matrix1[0][0]*(matrix1[1][1]*matrix1[2][2] -matrix1[2][1]*matrix1[1][2] ) - matrix1[0][1]*( matrix1[1][0]*matrix1[2][2] - matrix1[2][0]*matrix1[1][2] )  + matrix1[0][2]*( matrix1[1][0]*matrix1[2][1] - matrix1[2][0]*matrix1[1][1]     )      );       
                    }
                }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Column Matrix");
                newlabels.add("Rectangular Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;

            }
            if(idchoice==4){
                //Square matrix
                System.out.println("You have selected Square Matrix , Your matrix is ");
                System.out.println("Enter the number of rows");
                int row1=sc.nextInt();
                System.out.println("Enter the number of columns");
                int col1=sc.nextInt();
                int[][] matrix1 = new int[row1][col1];
                ///Taking input of matrix 1
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {

                        matrix1[i][j] = rd.nextInt(30)+3;
                    }
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==5){
                //Symmetric Matrix
                System.out.println("You have selected Symmetric Matrix , Your matrix is ");
                System.out.println("Enter the number of rows and columns");
                int randc = sc.nextInt();
                int row1=randc;
                int col1=randc;
                int[][] matrix1 = new int[row1][col1];
                if (randc ==2){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+2;
                    matrix1[1][0]=rd.nextInt(30)+2;
                    matrix1[0][1]=matrix1[1][0];
                }
                if(randc==3){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+2;
                    matrix1[1][0]=rd.nextInt(30)+2;
                    matrix1[2][0]=rd.nextInt(30)+2;
                    matrix1[2][1]=rd.nextInt(30)+2;
                    matrix1[2][2]=rd.nextInt(30)+2;
                    matrix1[0][1]=matrix1[1][0];
                    matrix1[2][1]=matrix1[1][2];
                    matrix1[2][0]=matrix1[0][2];
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                newlabels.add("Symmetric Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;

            }
            if(idchoice ==6){
                //Skew Symmetric Matrix
                System.out.println("You have selected Skew Symmetric Matrix , Your matrix is ");
                System.out.println("Enter the number of rows and columns");
                int randc = sc.nextInt();
                int row1=randc;
                int col1=randc;
                int[][] matrix1 = new int[row1][col1];
                if (randc ==2){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+2;
                    matrix1[1][0]=rd.nextInt(30)+2;
                    matrix1[0][1]=(-1)*matrix1[1][0];
                }
                if(randc==3){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+2;
                    matrix1[1][0]=rd.nextInt(30)+2;
                    matrix1[0][2]=rd.nextInt(40)+2;
                    matrix1[1][2]=rd.nextInt(50)+2;
                    matrix1[2][2]=rd.nextInt(20)+2;
                    matrix1[0][1]=(-1)*matrix1[1][0];
                    matrix1[2][1]=(-1)*matrix1[1][2];
                    matrix1[2][0]=(-1)*matrix1[0][2];
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                newlabels.add("Skew Symmetric Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==7){
                //Upper Triangular Matrix
                System.out.println("You have selected Upper Triangular Matrix , Your matrix is ");
                System.out.println("Enter the number of rows and columns");
                int randc = sc.nextInt();
                int row1=randc;
                int col1=randc;
                int[][] matrix1 = new int[row1][col1];
                if (randc ==2){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+3;
                    matrix1[0][1]=rd.nextInt(40)+2;
                    matrix1[1][0]=0;
                }
                if(randc==3){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+2;
                    matrix1[0][1]=rd.nextInt(30)+2;
                    matrix1[0][2]=rd.nextInt(30)+2;
                    matrix1[1][2]=rd.nextInt(20)+2;
                    matrix1[2][2]=rd.nextInt(30)+2;
                    matrix1[1][0]=0;
                    matrix1[2][1]=0;
                    matrix1[2][0]=0;
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                newlabels.add("Upper Triangular Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
                
            }
            if(idchoice==8){
                //Lower Triangular Matrix
                System.out.println("You have selected Lower Triangular Matrix , Your matrix is ");
                System.out.println("Enter the number of rows and columns");
                int randc = sc.nextInt();
                int row1=randc;
                int col1=randc;
                int[][] matrix1 = new int[row1][col1];
                if (randc ==2){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+2;
                    matrix1[1][0]=rd.nextInt(30)+2;
                    matrix1[0][1]=0;
                }
                if(randc==3){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+2;
                    matrix1[1][0]=rd.nextInt(30)+2;
                    matrix1[2][0]=rd.nextInt(30)+2;
                    matrix1[2][1]=rd.nextInt(30)+2;
                    matrix1[2][2]=rd.nextInt(30)+2;
                    matrix1[0][1]=0;
                    matrix1[1][2]=0;
                    matrix1[0][2]=0;
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                newlabels.add("Lower Triangular Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==9){
                //Singular matrix
                System.out.println("You have selected Singular Matrix , Your matrix is ");
                System.out.println("Enter the number of rows and columns");
                int randc = sc.nextInt();
                int row1=randc;
                int col1=randc;
                int[][] matrix1 = new int[row1][col1];
                if(randc ==2){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[0][1]=rd.nextInt(30)+2;
                    matrix1[1][0]=matrix1[0][0];
                    matrix1[1][1]=matrix1[0][1];
                }
                if(randc ==3){
                    matrix1[0][0]=rd.nextInt(30)+3;
                    matrix1[0][1]=rd.nextInt(30)+3;
                    matrix1[0][2]=rd.nextInt(30)+3;
                    matrix1[1][0]=matrix1[0][0];
                    matrix1[1][1]=matrix1[0][1];
                    matrix1[1][2]=matrix1[0][2];
                    matrix1[2][0]=rd.nextInt(30)+3;
                    matrix1[2][1]=rd.nextInt(30)+2;
                    matrix1[2][2]=rd.nextInt(30)+2;
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                newlabels.add("Singular Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==10){
                //Diagonal Matrix
                System.out.println("You have selected Diagonal Matrix , Your matrix is ");
                System.out.println("Enter the number of rows and columns");
                int randc = sc.nextInt();
                int row1=randc;
                int col1=randc;
                int[][] matrix1 = new int[row1][col1];
                if(randc==2){
                    matrix1[0][0]=rd.nextInt(40)+2;
                    matrix1[1][1]=rd.nextInt(40)+2;
                    matrix1[1][0]=0;
                    matrix1[0][1]=0;
                }
                if(randc==3){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=rd.nextInt(30)+2;
                    matrix1[2][2]=rd.nextInt(30)+2;
                    matrix1[1][0]=0;
                    matrix1[0][1]=0;
                    matrix1[2][0]=0;
                    matrix1[0][2]=0;
                    matrix1[1][2]=0;
                    matrix1[2][1]=0;
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                newlabels.add("Diagonal Matrix");
                newlabels.add("Symmetric Matrix");
                newlabels.add("Skew Symmetric Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==11){
                //Scalar Matrix
                System.out.println("You have selected Scalar Matrix , Your matrix is ");
                System.out.println("Enter the number of rows and columns");
                int randc = sc.nextInt();
                int row1=randc;
                int col1=randc;
                int[][] matrix1 = new int[row1][col1];
                if(randc==2){
                    matrix1[0][0]=rd.nextInt(40)+2;
                    matrix1[1][1]=matrix1[0][0];
                    matrix1[1][0]=0;
                    matrix1[0][1]=0;
                }
                if(randc==3){
                    matrix1[0][0]=rd.nextInt(30)+2;
                    matrix1[1][1]=matrix1[0][0];
                    matrix1[2][2]=matrix1[0][0];
                    matrix1[1][0]=0;
                    matrix1[0][1]=0;
                    matrix1[2][0]=0;
                    matrix1[0][2]=0;
                    matrix1[1][2]=0;
                    matrix1[2][1]=0;
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                newlabels.add("Diagonal Matrix");
                newlabels.add("Symmetric Matrix");
                newlabels.add("Skew Symmetric Matrix");
                newlabels.add("Scalar Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==12){
                //Identity Matrix
                System.out.println("You have selected Idenity Matrix , Your matrix is ");
                System.out.println("Enter the number of rows and columns");
                int randc = sc.nextInt();
                int row1=randc;
                int col1=randc;
                int[][] matrix1 = new int[row1][col1];
                if(randc==2){
                    matrix1[0][0]=1;
                    matrix1[1][1]=matrix1[0][0];
                    matrix1[1][0]=0;
                    matrix1[0][1]=0;
                }
                if(randc==3){
                    matrix1[0][0]=1;
                    matrix1[1][1]=matrix1[0][0];
                    matrix1[2][2]=matrix1[0][0];
                    matrix1[1][0]=0;
                    matrix1[0][1]=0;
                    matrix1[2][0]=0;
                    matrix1[0][2]=0;
                    matrix1[1][2]=0;
                    matrix1[2][1]=0;
                }
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Square Matrix");
                newlabels.add("Diagonal Matrix");
                newlabels.add("Symmetric Matrix");
                newlabels.add("Skew Symmetric Matrix");
                newlabels.add("Scalar Matrix");
                newlabels.add("Identity Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==13){
                //Singleton Matrix
                System.out.println("You have selected Singleton Matrix , Your matrix is ");
                int row1=1;
                int col1=1;
                int[][] matrix1 = new int[row1][col1];
                matrix1[0][0]=rd.nextInt(20)+2;
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                newlabels.add("Row Matrix");
                newlabels.add("Column Matrix");
                newlabels.add("Square Matrix");
                newlabels.add("Diagonal Matrix");
                newlabels.add("Symmetric Matrix");
                newlabels.add("Skew Symmetric Matrix");
                newlabels.add("Scalar Matrix");
                newlabels.add("Singleton Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            if(idchoice==14){
                //Ones Matrix
                System.out.println("You have selected Ones Matrix , Your matrix is ");
                System.out.println("Enter the number of rows");
                int row1 =sc.nextInt();
                System.out.println("Enter the number of columns");
                int col1 = sc.nextInt();
                System.out.println("Your matrix is");
                int[][] matrix1 = new int[row1][col1];
                ///Taking input of matrix 1
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {

                        matrix1[i][j] = 1;
                    }
                }
                
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                if(row1==col1){
                    newlabels.add("Square Matrix");
                }
                else{
                    newlabels.add("Rectangular Matrix");
                }
                newlabels.add("Ones Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            ////
            if(idchoice==15){
                //Ones Matrix
                System.out.println("You have selected Null Matrix , Your matrix is ");
                System.out.println("Enter the number of rows");
                int row1 =sc.nextInt();
                System.out.println("Enter the number of columns");
                int col1 = sc.nextInt();
                System.out.println("Your matrix is");
                int[][] matrix1 = new int[row1][col1];
                ///Taking input of matrix 1
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {

                        matrix1[i][j] = 0;
                    }
                }
                
                for (int i = 0; i < row1; i++)
	            {
                    for (int j = 0; j < col1; j++)
                    {
                        System.out.print(matrix1[i][j]+"\t");
                    }
                    
                    System.out.println();
	            }
                List<String> newlabels = new ArrayList<String>();
                if(row1==col1){
                    newlabels.add("Square Matrix");
                }
                else{
                    newlabels.add("Rectangular Matrix");
                }
                newlabels.add("Null Matrix");
                matricesdata newmatrix1 = new matricesdata(matrix1 , row1 , col1 , newlabels , matrixcount);
                System.out.println("The id of this matrix is "+matrixcount);
                allmatricesid.put(matrixcount , newmatrix1);
                allmatrices.add(newmatrix1);
                matrixcount = matrixcount+1;
            }
            //////////////
            ///Adding the new labels
            


        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(choice == 3){
            //Changing the matrix elements
            System.out.println("Changing the values of matrix");
            System.out.println("Enter the id of the matrix of you want to change");
            int cidchoice = sc.nextInt();
            int[][] temp = new int[ allmatrices.get(cidchoice).getRows() ][allmatrices.get(cidchoice).getColumns()];
            //temp = allmatrices.get(cidchoice).getMatrix();
            for (int i = 0; i < allmatrices.get(cidchoice).getRows(); i++)
	        {
	            for (int j = 0; j < allmatrices.get(cidchoice).getColumns(); j++)
	            {
	                temp[i][j]=allmatrices.get(cidchoice).getMatrix()[i][j];
	            }

	        }
            System.out.println("Enter the row of element you want to change");
            int rchoice = sc.nextInt();
            System.out.println("Enter the column of element you want to change");
            int cchoice = sc.nextInt();
            int row1= allmatrices.get(cidchoice).getRows();
            int col1= allmatrices.get(cidchoice).getColumns();
            rchoice= rchoice-1;
            cchoice = cchoice -1;
            System.out.println("Enter the new integer");
            int nint= sc.nextInt();
            temp[rchoice][cchoice] = nint;
            /////
            if(row1==1) {
                determinant=temp[0][0];
            }
            if (row1==2) {
                determinant = (temp[0][0]*temp[1][1])-(temp[1][0]*temp[0][1])  ;
            }
            if(row1==3){
                determinant = ( temp[0][0]*(temp[1][1]*temp[2][2] -temp[2][1]*temp[1][2] ) - temp[0][1]*( temp[1][0]*temp[2][2] - temp[2][0]*temp[1][2] )  + temp[0][2]*( temp[1][0]*temp[2][1] - temp[2][0]*temp[1][1]     )      );       
            }
            ///////////////////////
            System.out.println("The matrix before change");
            for (int i = 0; i < allmatrices.get(cidchoice).getRows(); i++)
	        {
	            for (int j = 0; j < allmatrices.get(cidchoice).getColumns(); j++)
	            {
	                System.out.print(allmatrices.get(cidchoice).getMatrix()[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
            ///////////////////////


            if ( allmatrices.get(cidchoice).getNewlabels().contains("Singular Matrix") ){
                if ( determinant ==0){
                    allmatrices.get(cidchoice).setMatrix(temp) ;
                    System.out.println("Matrix Updated");
                }
                else{
                    System.out.println(" Matrix won't be singular anymore!!");
                }
            }
            if(  allmatrices.get(cidchoice).getNewlabels().contains("Diagonal Matrix") ){
                if(row1 ==2){
                    if ( temp[0][1]==0 && temp[1][0]==0){
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be diagonal anymore!!");
                    }
                }
                if(row1==3){
                    if( temp[0][1]==0 && temp[0][2]==0 && temp[1][2]==0 && temp[1][0]==0 && temp[2][0]==0 && temp[2][1]==0 ){
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be diagonal anymore!!");
                    }

                }
            }
            if(allmatrices.get(cidchoice).getNewlabels().contains("Scalar Matrix") ){
                if(row1==2){
                    if( temp[1][0]==0 && temp[0][1]==0  ){
                        if(temp[0][0]==temp[1][1]){
                            allmatrices.get(cidchoice).setMatrix(temp) ;
                            System.out.println("Matrix Updated");
                        }
                        else{
                            System.out.println(" Matrix won't be scalar anymore!!");
                        }
                    }
                }
                if(row1==3){
                    if( temp[0][1]==0 && temp[0][2]==0 && temp[1][2]==0 && temp[1][0]==0 && temp[2][0]==0 && temp[2][1]==0 ){
                        if(temp[0][0]==temp[1][1] && temp[1][1]== temp[2][2]){
                            allmatrices.get(cidchoice).setMatrix(temp) ;
                            System.out.println("Matrix Updated");
                        }
                        else{
                            System.out.println(" Matrix won't be scalar anymore!!");
                        }
                        
                    }
                    else{
                        System.out.println(" Matrix won't be scalar anymore!!");
                    }
                }
            }
            if(allmatrices.get(cidchoice).getNewlabels().contains("Identity Matrix")){
                if(row1==2){
                    if( temp[1][0]==0 && temp[0][1]==0  ){
                        if(temp[0][0]== 1  && temp[1][1]==1){
                            allmatrices.get(cidchoice).setMatrix(temp) ;
                            System.out.println("Matrix Updated");
                        }
                        else{
                            System.out.println(" Matrix won't be Idenity anymore!!");
                        }
                    }
                }
                if(row1==3){
                    if( temp[0][1]==0 && temp[0][2]==0 && temp[1][2]==0 && temp[1][0]==0 && temp[2][0]==0 && temp[2][1]==0 ){
                        if(temp[0][0]==1 && temp[1][1]==1 && temp[2][2]==1){
                            allmatrices.get(cidchoice).setMatrix(temp) ;
                            System.out.println("Matrix Updated");
                        }
                        else{
                            System.out.println(" Matrix won't be Idenity anymore!!");
                        }
                        
                    }
                    else{
                        System.out.println(" Matrix won't be scalar anymore!!");
                    }
                }
            }
            if( allmatrices.get(cidchoice).getNewlabels().contains("Ones Matrix")){
                int change = 0;
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {
                        if ( temp[i][j] != 1 ){
                            change = change +1;
                        }
                    }

                }
                if ( change == 0){
                    allmatrices.get(cidchoice).setMatrix(temp) ;
                    System.out.println("Matrix Updated");
                }
                else{
                    System.out.println(" Matrix won't be ones matrix anymore!!");
                }
            }
            //
            if( allmatrices.get(cidchoice).getNewlabels().contains("Null Matrix")){
                int change = 0;
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {
                        if ( temp[i][j] != 0 ){
                            change = change +1;
                        }
                    }

                }
                if ( change == 0){
                    allmatrices.get(cidchoice).setMatrix(temp) ;
                    System.out.println("Matrix Updated");
                }
                else{
                    System.out.println(" Matrix won't be null matrix anymore!!");
                }
            }
            if( allmatrices.get(cidchoice).getNewlabels().contains("Symmetric Matrix") ){
                if(row1==2){
                    if(temp[0][1]==temp[1][0] ){
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be Symmetric matrix anymore!!");
                    }
                }
                if(row1==3){
                    if(temp[0][1]==temp[1][0] && temp[2][0]==temp[0][2] && temp[1][2]==temp[2][1]){
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be Symmetric matrix anymore!!");
                    }
                }
            }
            ////
            if( allmatrices.get(cidchoice).getNewlabels().contains("Skew Symmetric Matrix") ){
                if(row1==2){
                    if(temp[0][1]==(-1)*temp[1][0] ){
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be Symmetric matrix anymore!!");
                    }
                }
                if(row1==3){
                    if(temp[0][1]==(-1)*temp[1][0] && temp[2][0]==(-1)*temp[0][2] && temp[1][2]==(-1)*temp[2][1]){
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be Skew Symmetric matrix anymore!!");
                    }
                }
            }
            ////
            if( allmatrices.get(cidchoice).getNewlabels().contains("Upper Triangular Matrix") ){
                if(row1==2){
                    if(temp[1][0]==0 ){
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be Upper triangular matrix anymore!!");
                    }
                }
                if(row1==3){
                    if(temp[1][0]==0 && temp[2][0]==0 && temp[2][1]==0)   {
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be Upper trianular matrix anymore!!");
                    }
                }
            }
            ////
            if( allmatrices.get(cidchoice).getNewlabels().contains("Lower Triangular Matrix") ){
                if(row1==2){
                    if(temp[0][1]==0 ){
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be Lower triangular matrix anymore!!");
                    }
                }
                if(row1==3){
                    if(temp[0][1]==0 && temp[0][2]==0 && temp[1][2]==0)   {
                        allmatrices.get(cidchoice).setMatrix(temp) ;
                        System.out.println("Matrix Updated");
                    }
                    else{
                        System.out.println(" Matrix won't be lower trianular matrix anymore!!");
                    }
                }
            }
            ////
            //////
            if( allmatrices.get(cidchoice).getNewlabels().contains("Null Matrix") == false && allmatrices.get(cidchoice).getNewlabels().contains("Ones Matrix") == false ){
                if(allmatrices.get(cidchoice).getNewlabels().contains("Lower Traingular Matrix") == false && allmatrices.get(cidchoice).getNewlabels().contains("Upper Traingular Matrix") == false){
                    if(allmatrices.get(cidchoice).getNewlabels().contains("Skew Symmteric Matrix") == false && allmatrices.get(cidchoice).getNewlabels().contains("Symmteric Matrix") == false && allmatrices.get(cidchoice).getNewlabels().contains("Singular Matrix") == false ){
                        if(allmatrices.get(cidchoice).getNewlabels().contains("Identity Matrix") == false && allmatrices.get(cidchoice).getNewlabels().contains("Diagonal Matrix") == false && allmatrices.get(cidchoice).getNewlabels().contains("Scalar Matrix") == false ){
                            allmatrices.get(cidchoice).setMatrix(temp) ;
                            System.out.println("Matrix Updated");
                        }
                    }
                }
            }
            //////
            //Checking new Labels
            if ( allmatrices.get(cidchoice).getNewlabels().contains("Scalar Matrix") == false ){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();
                if(row1 == col1){
                    if (row1==1){
                        newlabels1.add("Scalar Matrix");
                    }
                    if(row1==2){
                        if( matrix1[1][0]==0 && matrix1[0][1]==0  ){
                            if(matrix1[0][0]==matrix1[1][1]){
                                newlabels1.add("Scalar Matrix");
                            }
                        }
                    }
                    if(row1==3){
                        if( matrix1[0][1]==0 && matrix1[0][2]==0 && matrix1[1][2]==0 && matrix1[1][0]==0 && matrix1[2][0]==0 && matrix1[2][1]==0 ){
                            if(matrix1[0][0]==matrix1[1][1] && matrix1[1][1]== matrix1[2][2]){
                                newlabels1.add("Scalar Matrix");
                            }
                        }
                    }
                }
                allmatrices.get(cidchoice).setNewlabels(newlabels1);
            }
            ///
            if  ( allmatrices.get(cidchoice).getNewlabels().contains("Diagonal Matrix") == false ){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();
                if(row1 == col1){
                    if (row1==1){
                        newlabels1.add("Diagonal Matrix");
                    }
                    if(row1==2){
                        if( matrix1[1][0]==0 && matrix1[0][1]==0  ){
                            newlabels1.add("Diagonal Matrix");
                        }
                    }
                    if(row1==3){
                        if( matrix1[0][1]==0 && matrix1[0][2]==0 && matrix1[1][2]==0 && matrix1[1][0]==0 && matrix1[2][0]==0 && matrix1[2][1]==0 ){
                            newlabels1.add("Diagonal Matrix");
                        }
                    }
                }
                allmatrices.get(cidchoice).setNewlabels(newlabels1); 
            }
            if  ( allmatrices.get(cidchoice).getNewlabels().contains("Identity Matrix") == false ){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();

                if(row1 == col1){
                    if (row1==1){
                        if (matrix1[0][0]==1){
                            newlabels1.add("Identity Matrix");
                        }
                    }
                    if(row1==2){
                        if( matrix1[1][0]==0 && matrix1[0][1]==0  ){
                            if(matrix1[0][0]==matrix1[1][1]){
                                if (matrix1[0][0]==1){
                                    newlabels1.add("Identity Matrix");
                                }
                            }
                        }
                    }
                    if(row1==3){
                        if( matrix1[0][1]==0 && matrix1[0][2]==0 && matrix1[1][2]==0 && matrix1[1][0]==0 && matrix1[2][0]==0 && matrix1[2][1]==0 ){
                            if(matrix1[0][0]==matrix1[1][1] && matrix1[1][1]== matrix1[2][2]){
                                if (matrix1[0][0]==1){
                                    newlabels1.add("identity Matrix");
                                }
                            }
                        }
                    }
                } 

                allmatrices.get(cidchoice).setNewlabels(newlabels1); 
            }
            if ( allmatrices.get(cidchoice).getNewlabels().contains("Symmteric Matrix") == false ){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();
                if(row1==2){
                    if ( matrix1[0][1]==matrix1[1][0] ){
                        newlabels1.add("Symmetric Matrix");
                    }
                }
                if(row1==3){
                    if(matrix1[0][1]==matrix1[1][0] && matrix1[2][0]==matrix1[0][2] && matrix1[1][2]==matrix1[2][1] ){
                        newlabels1.add("Symmetric Matrix");
                    }
                }
                allmatrices.get(cidchoice).setNewlabels(newlabels1);
            }
            if ( allmatrices.get(cidchoice).getNewlabels().contains("Skew Symmteric Matrix") == false ){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();
                if(row1==2){
                    if ( matrix1[0][1]==(-1)*matrix1[1][0] ){
                        newlabels1.add("Skew Symmetric Matrix");
                    }
                }
                if(row1==3){
                    if(matrix1[0][1]==(-1)*matrix1[1][0] && matrix1[2][0]==(-1)*matrix1[0][2] && matrix1[1][2]==(-1)*matrix1[2][1] ){
                        newlabels1.add("Skew Symmetric Matrix");
                    }
                }
                allmatrices.get(cidchoice).setNewlabels(newlabels1);
            }
            //
            if ( allmatrices.get(cidchoice).getNewlabels().contains("Upper Triangular Matrix") == false ){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();
                if(row1==2){
                    if ( matrix1[1][0]==0 ){
                        newlabels1.add("Upper Triangular Matrix");
                    }
                }
                if(row1==3){
                    if(matrix1[1][0]==0 && matrix1[2][0]==0 && matrix1[2][1]==0 ){
                        newlabels1.add("Upper Triangular Matrix");
                    }
                }
                allmatrices.get(cidchoice).setNewlabels(newlabels1);
            }
            if ( allmatrices.get(cidchoice).getNewlabels().contains("Lower Triangular Matrix") == false ){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();
                if(row1==2){
                    if ( matrix1[0][1]==0 ){
                        newlabels1.add("Lower Triangular Matrix");
                    }
                }
                if(row1==3){
                    if(matrix1[0][1]==0 && matrix1[0][1]==0 && matrix1[1][2]==0 ){
                        newlabels1.add("Lower Triangular Matrix");
                    }
                }
                allmatrices.get(cidchoice).setNewlabels(newlabels1);
            }
            if( allmatrices.get(cidchoice).getNewlabels().contains("Ones Matrix") == false){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();
                int change =0;
                for (int i = 0 ; i<allmatrices.get(cidchoice).getRows() ;i++){
                    for (int j =0 ; j<allmatrices.get(cidchoice).getColumns() ; j++){
                        if(matrix1[i][j] != 1){
                            change = change +1;
                        }
                    }
                }
                if(change ==0){
                    newlabels1.add("Ones Matrix");
                }
            }
            if( allmatrices.get(cidchoice).getNewlabels().contains("Null Matrix") == false){
                int[][] matrix1 = allmatrices.get(cidchoice).getMatrix();
                List<String> newlabels1= allmatrices.get(cidchoice).getNewlabels();
                int change =0;
                for (int i = 0 ; i<allmatrices.get(cidchoice).getRows() ;i++){
                    for (int j =0 ; j<allmatrices.get(cidchoice).getColumns() ; j++){
                        if(matrix1[i][j] != 0){
                            change = change +1;
                        }
                    }
                }
                if(change ==0){
                    newlabels1.add("Null Matrix");
                }
            }
            
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("The matrix after change");
            for (int i = 0; i < allmatrices.get(cidchoice).getRows(); i++)
	        {
	            for (int j = 0; j < allmatrices.get(cidchoice).getColumns(); j++)
	            {
	                System.out.print(allmatrices.get(cidchoice).getMatrix()[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        }
        ////////
        if (choice == 4){
            System.out.println("Printing Labels");
            System.out.println("Enter the id of the matrix of you want to print the labels");
            int labelidchoice = sc.nextInt();
            for(String name:allmatrices.get(labelidchoice).getNewlabels()) {
                System.out.println(name);
            }

        }
        ////
        if (choice ==5){
            System.out.println("2 Matrix operations");
            System.out.println("Enter the id of the 1st matrix ");
            int opchoice1 = sc.nextInt();
            System.out.println("Enter the id of the 2nd matrix ");
            int opchoice2 = sc.nextInt();
            int[][] retadd = allmatrices.get(opchoice1).addition(allmatrices.get(opchoice1).getMatrix() ,allmatrices.get(opchoice1).getRows() ,allmatrices.get(opchoice1).getColumns() , allmatrices.get(opchoice2).getMatrix() );
            int[][] retsub = allmatrices.get(opchoice1).subtraction(allmatrices.get(opchoice1).getMatrix() ,allmatrices.get(opchoice1).getRows() ,allmatrices.get(opchoice1).getColumns() , allmatrices.get(opchoice2).getMatrix() );
            
            int[][] retcmul = allmatrices.get(opchoice1).intcrossmultiplication(allmatrices.get(opchoice1).getMatrix() , allmatrices.get(opchoice1).getRows() , allmatrices.get(opchoice1).getColumns(), allmatrices.get(opchoice2).getRows(), allmatrices.get(opchoice2).getColumns(), allmatrices.get(opchoice2).getMatrix());
            //Division left///////////////////////////////////////////////////////////////////
            if(allmatrices.get(opchoice2).getNewlabels().contains("Singular Matrix")){
                ////
                float[][] inverted = new float[1][1];
                inverted[0][0]=0;
                singular newmatrix2 = new singular(allmatrices.get(opchoice2).getMatrix(),allmatrices.get(opchoice2).getRows(), allmatrices.get(opchoice2).getColumns() ,  allmatrices.get(opchoice2).getNewlabels(), allmatrices.get(opchoice2).getMatrixcount() );

                float[][] retfdiv = newmatrix2.floatcrossmultiplication(allmatrices.get(opchoice1).getMatrix() , allmatrices.get(opchoice1).getRows() , allmatrices.get(opchoice1).getColumns(), allmatrices.get(opchoice2).getRows(), allmatrices.get(opchoice2).getColumns(), inverted);
                //
                //singular newmatrix2 = new singular(allmatrices.get(deterchoice).getMatrix(),allmatrices.get(deterchoice).getRows(), allmatrices.get(deterchoice).getColumns() ,  allmatrices.get(deterchoice).getNewlabels(), allmatrices.get(deterchoice).getMatrixcount() );
                //int retval = newmatrix2.caldeterminant(newmatrix2.getMatrix() , newmatrix2.getRows() ,newmatrix2.getColumns() );


            }
            else{
            float[][] inverted = allmatrices.get(opchoice2).invert(allmatrices.get(opchoice2).getMatrix() , allmatrices.get(opchoice2).getRows() , allmatrices.get(opchoice2).getColumns());
            float[][] retfdiv = allmatrices.get(opchoice1).floatcrossmultiplication(allmatrices.get(opchoice1).getMatrix() , allmatrices.get(opchoice1).getRows() , allmatrices.get(opchoice1).getColumns(), allmatrices.get(opchoice2).getRows(), allmatrices.get(opchoice2).getColumns(), inverted);
            }
        }
        ////
        if(choice ==6 ){
            System.out.println("Element Wise multiplication and Division");
            System.out.println("Enter the id of the 1st matrix ");
            int eopchoice1 = sc.nextInt();
            System.out.println("Enter the id of the 2nd matrix ");
            int eopchoice2 = sc.nextInt();
            int[][] retemul = allmatrices.get(eopchoice1).elementmultiplication(allmatrices.get(eopchoice1).getMatrix() ,allmatrices.get(eopchoice1).getRows() ,allmatrices.get(eopchoice1).getColumns() , allmatrices.get(eopchoice2).getMatrix() );
            float[][] retediv = allmatrices.get(eopchoice1).elementdivision(allmatrices.get(eopchoice1).getMatrix() ,allmatrices.get(eopchoice1).getRows() ,allmatrices.get(eopchoice1).getColumns() , allmatrices.get(eopchoice2).getMatrix() );

        }
        ////


		if (choice == 7){
			System.out.println("Computing transpose");
			System.out.println("Enter the id of matrix for computing transpose");
			int transposechoice = sc.nextInt();
            if(allmatrices.get(transposechoice).getNewlabels().contains("Symmetric Matrix")){
                symmetric newmatrix2 = new symmetric(allmatrices.get(transposechoice).getMatrix(),allmatrices.get(transposechoice).getRows(), allmatrices.get(transposechoice).getColumns() ,  allmatrices.get(transposechoice).getNewlabels()  , allmatrices.get(transposechoice).getMatrixcount());
                int[][] retval = newmatrix2.caltranspose(newmatrix2.getMatrix() , newmatrix2.getRows() ,newmatrix2.getColumns() );
            }
            if(allmatrices.get(transposechoice).getNewlabels().contains("Skew Symmetric Matrix")){
                skewsymmetric newmatrix2 = new skewsymmetric(allmatrices.get(transposechoice).getMatrix(),allmatrices.get(transposechoice).getRows(), allmatrices.get(transposechoice).getColumns() , allmatrices.get(transposechoice).getNewlabels() , allmatrices.get(transposechoice).getMatrixcount() );
                int[][] retval = newmatrix2.caltranspose(newmatrix2.getMatrix() , newmatrix2.getRows() ,newmatrix2.getColumns() );
            }
            
            else{
			int[][] retval = allmatrices.get(transposechoice).caltranspose(allmatrices.get(transposechoice).getMatrix() , allmatrices.get(transposechoice).getRows() ,allmatrices.get(transposechoice).getColumns() );
			System.out.println("Your transposed Matrix is : ");
	        
	        for (int i = 0; i < allmatrices.get(transposechoice).getColumns(); i++)
	        {
	            for (int j = 0; j < allmatrices.get(transposechoice).getRows(); j++)
	            {
	                System.out.print(retval[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        }
		}

        if(choice==8){
            //Inverse of the matrix
            System.out.println("Enter the id of matrix for inverse");
            int invchoice = sc.nextInt();
            System.out.println("Printing the inverse");
            float[][] output = allmatrices.get(invchoice).invert(allmatrices.get(invchoice).getMatrix() , allmatrices.get(invchoice).getRows() , allmatrices.get(invchoice).getColumns());
            for ( int i=0 ; i<allmatrices.get(invchoice).getRows() ; i++){
                for (int j=0 ; j<allmatrices.get(invchoice).getColumns();j++){
                    System.out.print(output[i][j]+"\t");
                }
                System.out.println();
            }

        }

        if (choice ==9){
            System.out.println("Calculating mean");
            System.out.println("Enter the id of matrix for computing the mean");
			int meanchoice = sc.nextInt();
            
            ////
            if(allmatrices.get(meanchoice).getNewlabels().contains("Ones Matrix")){
                /// 
                onesmatrix newmatrix2 = new onesmatrix(allmatrices.get(meanchoice).getMatrix(),allmatrices.get(meanchoice).getRows(), allmatrices.get(meanchoice).getColumns() ,  allmatrices.get(meanchoice).getNewlabels() , allmatrices.get(meanchoice).getMatrixcount() );
                int retormean = newmatrix2.rowmean( newmatrix2.getMatrix() , newmatrix2.getRows() , newmatrix2.getColumns() );
                int retocmean = newmatrix2.colmean( newmatrix2.getMatrix() , newmatrix2.getColumns() , newmatrix2.getRows() );
                System.out.println("Mean of all elements");
                float retoamean = newmatrix2.mean(newmatrix2.getMatrix() , newmatrix2.getRows() , newmatrix2.getColumns() );

            }
            else if(allmatrices.get(meanchoice).getNewlabels().contains("NUll Matrix")){
                /// 
                nullmatrix newmatrix2 = new nullmatrix(allmatrices.get(meanchoice).getMatrix(),allmatrices.get(meanchoice).getRows(), allmatrices.get(meanchoice).getColumns() ,  allmatrices.get(meanchoice).getNewlabels(), allmatrices.get(meanchoice).getMatrixcount() );
                int retnrmean = newmatrix2.rowmean( newmatrix2.getMatrix() , newmatrix2.getRows() , newmatrix2.getColumns() );
                int retncmean = newmatrix2.colmean( newmatrix2.getMatrix() , newmatrix2.getColumns(), newmatrix2.getRows() );
                System.out.println("Mean of all elements");
                float retnamean = newmatrix2.mean(newmatrix2.getMatrix() , newmatrix2.getRows() , newmatrix2.getColumns() );

            }
            ////
            else {
            int retrmean = allmatrices.get(meanchoice).rowmean(allmatrices.get(meanchoice).getMatrix(), allmatrices.get(meanchoice).getRows() ,allmatrices.get(meanchoice).getColumns() );
            int retcmean = allmatrices.get(meanchoice).colmean(allmatrices.get(meanchoice).getMatrix(), allmatrices.get(meanchoice).getColumns()  ,allmatrices.get(meanchoice).getRows() );
            System.out.println("Mean of all elements");
            float retamean =allmatrices.get(meanchoice).mean(allmatrices.get(meanchoice).getMatrix(), allmatrices.get(meanchoice).getRows() , allmatrices.get(meanchoice).getColumns());
            }
            //Find for ones and null matrix
            
        }

		if (choice == 10) {
			System.out.println("Computing determinant");
			System.out.println("Enter the id of matrix for computing the determinant");
			int deterchoice = sc.nextInt();
            if( allmatrices.get(deterchoice).getNewlabels().contains("Singular Matrix")) {
                singular newmatrix2 = new singular(allmatrices.get(deterchoice).getMatrix(),allmatrices.get(deterchoice).getRows(), allmatrices.get(deterchoice).getColumns() ,  allmatrices.get(deterchoice).getNewlabels(), allmatrices.get(deterchoice).getMatrixcount() );
                int retval = newmatrix2.caldeterminant(newmatrix2.getMatrix() , newmatrix2.getRows() ,newmatrix2.getColumns() );

            }

            if (allmatrices.get(deterchoice).getNewlabels().contains("Square Matrix")) {
                int retval = allmatrices.get(deterchoice).caldeterminant(allmatrices.get(deterchoice).getMatrix() , allmatrices.get(deterchoice).getRows() ,allmatrices.get(deterchoice).getColumns() );
			    System.out.println("The determinant is \n"+ retval);
            }
            else{
                rectangular newmatrix2 = new rectangular(allmatrices.get(deterchoice).getMatrix(),allmatrices.get(deterchoice).getRows(), allmatrices.get(deterchoice).getColumns() ,  allmatrices.get(deterchoice).getNewlabels(), allmatrices.get(deterchoice).getMatrixcount() );
                int retval = newmatrix2.caldeterminant(newmatrix2.getMatrix() , newmatrix2.getRows() ,newmatrix2.getColumns() );
            }
			
			
		}
        if(choice==11){
            //Using singletom matrix as scalars
            System.out.println("Enter the id of matrix for operations");
            int matchoice = sc.nextInt();
            System.out.println("Enter the id of Singleton matrix for operations");
            int sinchoice = sc.nextInt();
            int s =  (allmatrices.get(sinchoice).getMatrix())[0][0];
            if(allmatrices.get( matchoice).getNewlabels().contains("Null Matrix") ){
                System.out.println("This is Null Matrix");
                nullmatrix newmatrix2 = new nullmatrix(allmatrices.get(matchoice).getMatrix(),allmatrices.get(matchoice).getRows(), allmatrices.get(matchoice).getColumns() , allmatrices.get(matchoice).getNewlabels() , allmatrices.get(matchoice).getMatrixcount() );
                int[][] retnmul = newmatrix2.dotmultiplication( newmatrix2.getMatrix() , newmatrix2.getRows() , newmatrix2.getColumns() , s);
                float[][] retndiv = newmatrix2.dotdivision( newmatrix2.getMatrix() , newmatrix2.getRows() , newmatrix2.getColumns() , s);

            }

            else{
            System.out.println("Multiplication of scalar number");
            int[][] retsmul = allmatrices.get(matchoice).dotmultiplication(allmatrices.get(matchoice).getMatrix() ,allmatrices.get(matchoice).getRows() ,allmatrices.get(matchoice).getColumns() , s );
            System.out.println("Division of scalar number");
            float[][] retsdiv = allmatrices.get(matchoice).dotdivision(allmatrices.get(matchoice).getMatrix() ,allmatrices.get(matchoice).getRows() ,allmatrices.get(matchoice).getColumns() , s );
            }

        }

        if(choice==12){
            // Compute A+At
            System.out.println("Computer A + At");
            System.out.println("Enter the id of matrix for operations");
            int addchoice = sc.nextInt();
            int[][] transpose = allmatrices.get(addchoice).caltranspose(allmatrices.get(addchoice).getMatrix() , allmatrices.get(addchoice).getRows() ,allmatrices.get(addchoice).getColumns() );
            int[][] output = allmatrices.get(addchoice).addition(allmatrices.get(addchoice).getMatrix() ,allmatrices.get(addchoice).getRows() ,allmatrices.get(addchoice).getColumns() , transpose );

        }
        if(choice == 13){
            //Computer eigen values
            System.out.println("Computing eigen values");
            System.out.println("Enter the id of matrix for finding eigen values");
            int eigchoice = sc.nextInt();
            float [][] eigenret = allmatrices.get(eigchoice).eigenvalues(allmatrices.get(eigchoice).getMatrix(), allmatrices.get(eigchoice).getRows(), allmatrices.get(eigchoice).getColumns());

        }
        if(choice ==14){
            //Solving linear equation
            System.out.println("Solving linear equation");
            System.out.println("Enter the id of matrix for LHS");
            int lhschoice = sc.nextInt();
            System.out.println("Enter the id of matrix for RHS , having same rows as LHS");
            int rhschoice = sc.nextInt();
            float[][] invlhs = allmatrices.get(lhschoice).invert(allmatrices.get(lhschoice).getMatrix() , allmatrices.get(lhschoice).getRows() , allmatrices.get(lhschoice).getColumns());
            float[][] answer = new float[allmatrices.get(lhschoice).getRows()][1];
            answer = allmatrices.get(lhschoice).crossmultiplication(invlhs , allmatrices.get(lhschoice).getRows() , allmatrices.get(lhschoice).getColumns(), allmatrices.get(rhschoice).getRows(), allmatrices.get(rhschoice).getColumns(), allmatrices.get(rhschoice).getMatrix());
            for (int i = 0; i < allmatrices.get(lhschoice).getRows(); i++)
	        {
	            for (int j = 0; j < 1; j++)
	            {
	                System.out.print(answer[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }

        }
        if(choice==15){
            //Find the matrix from labels
            String buffer = sc.nextLine();
            System.out.println("Enter the label , For example for square matrix , Enter 'Square Matrix' ");

            String label = sc.nextLine();
            System.out.println("The matrices are ");
            for (int k =0 ; k<(allmatrices.size());k++ ){
                if(allmatrices.get(k).getNewlabels().contains(label)){
                    System.out.println("ID is "+allmatrices.get(k).getMatrixcount());
                    for (int i = 0; i < allmatrices.get(k).getRows(); i++)
                    {
                        for (int j = 0; j < allmatrices.get(k).getColumns(); j++)
                        {
                        System.out.print(allmatrices.get(k).getMatrix()[i][j]+"\t");
                        }
                    
                    System.out.println();
                    }
                    System.out.println();
                }
            }
        }
		}
		
	}

	

}

class matricesdata{
	private int[][] matrix;
	private int rows;
	private int columns;
	private List<String> newlabels;
    private int matrixcount;
	
	matricesdata(int[][] matrix , int rows , int columns  ,  List<String> newlabels , int matrixcount){
		this.matrix = matrix;
		this.rows= rows;
		this.columns= columns;
		this.newlabels = newlabels;
        this.matrixcount = matrixcount;
	}
    public int getMatrixcount() {
		return matrixcount;
	}
    public void setMatrixcount(int matrixcount) {
		this.matrixcount = matrixcount;
	}
    public List<String> getNewlabels(){
        return newlabels;
    }
    public void setNewlabels(List<String> newlabels){
        this.newlabels = newlabels;
    }
	
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}

	//////
	public int[][] addition(int[][] matrix1 , int row1 , int col1 , int[][]matrix2 ){
        int[][] output= new int[row1][col1];
        for( int i=0 ; i<row1;i++){
            for(int j =0; j<col1 ;j++){
                output[i][j] = matrix1[i][j]+matrix2[i][j];
            }
        }
        ///
        System.out.println("The addition of 2 Matrices is");
            for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print(output[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        ///


        return output;

    }
	///////
	public int[][] subtraction(int[][] matrix1 , int row1 , int col1 , int[][] matrix2 ){
        int[][] output= new int[row1][col1];
        for( int i=0 ; i<row1;i++){
            for(int j =0; j<col1 ;j++){
                output[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        ///
        System.out.println("The Subtraction of 2 Matrices is");
            for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print(output[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        ///
        return output;

    }
	///////
	public int[][] dotmultiplication( int[][] matrix1 , int row1 , int col1 , int d){
        int[][] output = new int[row1][col1];
        for (int i=0 ; i<row1 ; i++){
            for (int j= 0 ;j<col1;j++){
                output[i][j]=d*matrix1[i][j];
            }
        }
        ///
        System.out.println("The Matrix after dot multiplication is ");
            for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print(output[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        ///
        return output;
    }
    ////////
    public float[][] dotdivision( int[][] matrix1 , int row1 , int col1 , int d){
        float[][] output = new float[row1][col1];
        for (int i=0 ; i<row1 ; i++){
            for (int j= 0 ;j<col1;j++){
                output[i][j]= (float)matrix1[i][j] / (float)d ;
            }
        }
        ///
        System.out.println("The Matrix after dot division is ");
            for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print(output[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        ///
        return output;
    }
	 ///////
	public int caldeterminant( int[][] matrix1 , int row1 , int col1){
        int determinant = -1;
        if (row1==col1) {
            if(row1==1) {
                determinant=matrix1[0][0];
            }
            if (row1==2) {
                determinant = (matrix1[0][0]*matrix1[1][1])-(matrix1[1][0]*matrix1[0][1])  ;
            }
            if(row1==3){
                determinant = ( matrix1[0][0]*(matrix1[1][1]*matrix1[2][2] -matrix1[2][1]*matrix1[1][2] ) - matrix1[0][1]*( matrix1[1][0]*matrix1[2][2] - matrix1[2][0]*matrix1[1][2] )  + matrix1[0][2]*( matrix1[1][0]*matrix1[2][1] - matrix1[2][0]*matrix1[1][1]     )      );       
            }
        }
        return determinant;
    }
	///////
	public int[][] elementmultiplication( int[][]matrix1 , int row1, int col1 , int[][] matrix2){
        int[][] output = new int[row1][col1];
        for ( int i=0 ; i<row1 ; i++){
            for (int j=0 ; j<col1;j++){
                output[i][j]=matrix1[i][j]*matrix2[i][j];
            }
        }
        ///
        System.out.println("The Matrix after element multiplication is ");
            for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print(output[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        ///
        return output;
    }
	///////
	public float[][] elementdivision( int[][]matrix1 , int row1, int col1 , int[][] matrix2){
        float[][] output = new float[row1][col1];
        for ( int i=0 ; i<row1 ; i++){
            for (int j=0 ; j<col1;j++){
                output[i][j]=(float)matrix1[i][j]/(float)matrix2[i][j];
            }
        }
        ///
        System.out.println("The Matrix after element division is ");
            for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print(output[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        ///
        return output;
    }
	///////
	public int[][] caltranspose(int[][]matrix1 ,int row1 , int col1){
        int[][] output = new int[col1][row1];
        for ( int i=0 ; i<row1 ; i++){
            for (int j=0 ; j<col1;j++){
                output[j][i]=matrix1[i][j];
            }
        }
        return output;
    }
	///////
	public int rowmean(int[][] matrix1 , int row1 , int col1){
        int r =0;
        float[][] rmean = new float[row1][1];
        if(row1==1){
            rmean[0][0]=matrix1[0][0];
        }
        if(row1==2){
            rmean[0][0]=((float)matrix1[0][0]+(float)matrix1[0][1])/2;
            rmean[1][0]=((float)matrix1[1][0]+(float)matrix1[1][1])/2;
        }
        if(row1==3){
            rmean[0][0]=((float)matrix1[0][0]+(float)matrix1[0][1]+(float)matrix1[0][2])/3;
            rmean[1][0]=((float)matrix1[1][0]+(float)matrix1[1][1]+(float)matrix1[1][2])/3;
            rmean[2][0]=((float)matrix1[2][0]+(float)matrix1[2][1]+(float)matrix1[2][2])/3;
        }
        System.out.println("The mean of rows is ");
        for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < 1; j++)
	            {
	                System.out.print(rmean[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        return r;
    }
	///////
	public int colmean(int[][] matrix1 , int col1 , int row1){
        int r =0;
        float[][] cmean = new float[1][col1];
        if(row1==1){
            cmean[0][0]=matrix1[0][0];
        }
        if(row1==2){
            cmean[0][0]=((float)matrix1[0][0]+(float)matrix1[1][0])/2;
            cmean[0][1]=((float)matrix1[0][1]+(float)matrix1[1][1])/2;
        }
        if(row1==3){
            cmean[0][0]=((float)matrix1[0][0]+(float)matrix1[1][0]+(float)matrix1[2][0])/3;
            cmean[0][1]=((float)matrix1[0][1]+(float)matrix1[1][1]+(float)matrix1[2][1])/3;
            cmean[0][2]=((float)matrix1[0][2]+(float)matrix1[1][2]+(float)matrix1[2][2])/3;
        }
        System.out.println("The mean of columns is");
        for (int i = 0; i < 1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print(cmean[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        return r;
    }
	///////
	public float mean (int[][]matrix1 , int row1 , int col1){
        float sum = 0;
        for ( int i=0 ; i<row1 ; i++){
            for (int j=0 ; j<col1;j++){
                sum=sum+matrix1[i][j];
            }
        }
        float output = sum / (row1*col1);
        System.out.println("The mean of all the elements is "+ output);
        return output;
    }
	///////
	public int[][] single(int[][]matrix1 , int[][]matrix2 , int row1 , int col1 ){
        int m = matrix1[0][0];   //Use singleton matrix as scalar
        int[][] output = new int[row1][col1];
        for (int i=0 ; i<row1 ; i++){
            for (int j= 0 ;j<col1;j++){
                output[i][j]=m*matrix1[i][j];
            }
        }
        return output;
    }
	///////
	public int[][] sumtran(int[][] matrix1 , int row1 , int col1 , int[][] transpose ){
        int[][] output = new int[row1][col1];        //Find A + A^T
        for ( int i=0 ; i<row1 ; i++){
            for (int j=0 ; j<col1;j++){
                output[i][j]=matrix1[i][j] + transpose[i][j];
            }
        }
        return output;
    }
	///////
    public float[][] invert( int[][] matrix1 , int row1 , int col1 ){
        float[][] output = new float[row1][col1];
        if (row1 == col1){
            if (row1 ==1){
                output[0][0]= 1 / (float)matrix1[0][0] ;
                 
            }
            if (row1 == 2){
                int determinant = (matrix1[0][0]*matrix1[1][1])-(matrix1[1][0]*matrix1[0][1])  ;
                output[0][0]=  (float)matrix1[1][1] / determinant;
                output[1][1]= (float)matrix1[0][0] / determinant;
                output[1][0]= (-1)*(float)matrix1[1][0] / determinant;
                output[0][1]= (-1)*(float)matrix1[0][1] / determinant;
            }
            if(row1==3){
                int determinant = ( matrix1[0][0]*(matrix1[1][1]*matrix1[2][2] -matrix1[2][1]*matrix1[1][2] ) - matrix1[0][1]*( matrix1[1][0]*matrix1[2][2] - matrix1[2][0]*matrix1[1][2] )  + matrix1[0][2]*( matrix1[1][0]*matrix1[2][1] - matrix1[2][0]*matrix1[1][1]     )      );       
                //Finding Cofactor
                float[][] cofactors = new float[row1][col1];
                cofactors[0][0]= (float)(matrix1[1][1] * matrix1[2][2] - matrix1[2][1]*matrix1[1][2]);
                cofactors [0][1]= (-1)* (float)(matrix1[1][0]*matrix1[2][2] - matrix1[2][0]*matrix1[1][2]  );
                cofactors[0][2]= (float)( matrix1[1][0]* matrix1[2][1] - matrix1[2][0]*matrix1[1][1] );
                cofactors[1][0]= (-1)* (float)( matrix1[0][1]*matrix1[2][2] - matrix1[2][1]*matrix1[0][2] );
                cofactors[1][1]= (float)(matrix1[0][0] * matrix1[2][2] - matrix1[2][0]*matrix1[0][2] );
                cofactors[1][2]= (-1)* (float)( matrix1[0][0]*matrix1[2][1] - matrix1[2][0]*matrix1[0][1] );
                cofactors[2][0] = (float)( matrix1[0][1]*matrix1[1][2] - matrix1[1][1]*matrix1[0][2] );
                cofactors[2][1] = (-1)*(float)(matrix1[0][0]*matrix1[1][2]  - matrix1[1][0]*matrix1[0][2] );
                cofactors[2][2]= (float)( matrix1[0][0]*matrix1[1][1] - matrix1[1][0]*matrix[0][1] );
                float[][] adjoint = new float[row1][col1];
                ////
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {
                        adjoint[i][j]= cofactors[i][j] / determinant ;   // adjoint matrix before transpose
                    }
                }
                ////
                float[][] adjucate = new float[row1][col1];
                for (int i = 0; i < row1; i++)
                {
                    for (int j = 0; j < col1; j++)
                    {
                        adjucate[j][i]= adjoint[i][j]; 
                    }
                }



                
                output = adjucate;

            }
        }

        return output;
    }
    /////
    float[][] crossmultiplication (float[][] matrix1 , int row1 , int col1 , int row2, int col2 , int[][] matrix2){
        float C[][] = new float[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++)
                    C[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
        return C;
    }
    ///////
    int[][] intcrossmultiplication (int[][] matrix1 , int row1 , int col1 , int row2, int col2 , int[][] matrix2){
        int C[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++)
                    C[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
        System.out.println("The Matrix after cross multiplication is ");
            for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col2; j++)
	            {
	                System.out.print(C[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        return C;
    }
    ///////
    float[][] floatcrossmultiplication (int[][] matrix1 , int row1 , int col1 , int row2, int col2 , float[][] matrix2){
        float C[][] = new float[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++)
                    C[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
        System.out.println("The Matrix after division is ");
            for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col2; j++)
	            {
	                System.out.print(C[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        return C;
    }
    ///////
    float[][] eigenvalues(int[][] matrix1 , int row1 , int col1){
        int i[][] = new int[row1][col1];
        float output[][] = new float[row1][col1];
        if (row1 ==1){
            output[0][0]=matrix1[0][0];
            System.out.println("The eigen value is"+ output[0][0]);
        }
        if(row1==2){
            int a = matrix1[0][0];
            int b = matrix1[0][1];
            int c = matrix1[1][0];
            int d = matrix1[1][1];
            double eigenvalue1 = ((a+d) + Math.sqrt( Math.pow(a-d,2) + 4*b*c))/2;
            double eigenvalue2 = ((a+d) - Math.sqrt( Math.pow(a-d,2) + 4*b*c))/2;
            System.out.println("The 1st eigen value is "+eigenvalue1);
            System.out.println("The second eigen value is "+eigenvalue2);
        }
        return output;
    }

    ///////

	
	
}


class rectangular extends matricesdata{
	
	rectangular(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
		super(matrix , rows , columns ,newlabels ,  matrixcount);
	}
	
	@Override
	public int caldeterminant( int[][]matrix1 , int row1 , int col1){
		System.out.println("Determinant is not possible for rectangular matrix");
		return -1;
	}
	
}


class rowmatrix extends rectangular{
	rowmatrix(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
		super(matrix , rows , columns ,  newlabels , matrixcount);
	}
}
class columnmatrix extends rectangular{
	columnmatrix(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
		super(matrix , rows , columns , newlabels , matrixcount);
	}
}



class square extends matricesdata{
	square(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
		super(matrix , rows , columns ,  newlabels , matrixcount);
	}
}

class symmetric extends square{
	symmetric(int[][] matrix , int rows , int columns , List<String> newlabels , int matrixcount){
		super(matrix , rows , columns , newlabels , matrixcount);
	}
    @Override
    public int[][] caltranspose(int[][]matrix1 , int row1 , int col1){
        System.out.println("This is a Symmetric matrix");
        for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print(matrix1[i][j]+"\t");
	            }
	             
	            System.out.println();
	        }
        return matrix1;  
    } 
}

class skewsymmetric extends square{
	skewsymmetric(int[][] matrix , int rows , int columns , List<String> newlabels , int matrixcount){
		super(matrix , rows , columns ,newlabels , matrixcount);
	}
    @Override
    public int[][] caltranspose(int[][]matrix1 , int row1 , int col1){
        System.out.println("This is a Skew Symmetric matrix");
        for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
                    if ( i!=j){
	                System.out.print((-1)* matrix1[i][j]+"\t");
                    }
                    else{
                        System.out.print( matrix1[i][j]+"\t");
                    }
	            }
	             
	            System.out.println();
	        }
        return matrix1;  
    } 
}

class uppertriangular extends square{
	uppertriangular(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
		super(matrix , rows , columns , newlabels , matrixcount);
	}
}

class lowertriangular extends square{
	lowertriangular(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
		super(matrix , rows , columns ,  newlabels , matrixcount);
	}
}

class singular extends square{
	singular(int[][] matrix , int rows , int columns ,  List<String> newlabels ,int matrixcount){
		super(matrix , rows , columns ,  newlabels , matrixcount);
	}
    @Override
    float[][] floatcrossmultiplication (int[][] matrix1 , int row1 , int col1 , int row2, int col2 , float[][] matrix2){
        float[][] C = new float[1][1];
        C[0][0]=0;
        System.out.println("Division with Singular Matrix in Denominator isn't possible ");
        return C;
    }
    @Override
    public int caldeterminant(int[][] matrix1 , int row1 , int col1 ){
        int a =0;
        System.out.println("This is Singular matrix , so determinant will be 0 ");
        return a;
    }
}

class diagonal extends square{
	diagonal(int[][] matrix , int rows , int columns , List<String> newlabels , int matrixcount){
		super(matrix , rows , columns , newlabels , matrixcount);
	}
}

class scalar extends diagonal{
	scalar(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
		super(matrix , rows , columns ,newlabels , matrixcount);
	}
}

class identity extends scalar{
	identity(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
		super(matrix , rows , columns ,  newlabels, matrixcount) ;
	}
}

class onesmatrix extends matricesdata{
    onesmatrix(int[][] matrix , int rows , int columns ,  List<String> newlabels, int matrixcount){
        super(matrix , rows  ,columns ,  newlabels , matrixcount);
    }
    @Override
    public int rowmean(int[][] matrix1 ,int r, int col1){
        System.out.println("This is a ones matrix , The row mean is 1");
        return 1;
    }

    @Override
    public int colmean(int[][] matrix1, int c , int row1){
        System.out.println("This is a ones matrix , The column mean is 1");
        return 1;
    }

    @Override
    public float mean(int[][] matrix1 , int row1, int col1){
        System.out.println("This is a ones matrix , The mean is 1");
        return 1;
    }

    
}
class nullmatrix extends matricesdata{
    nullmatrix(int[][] matrix , int rows , int columns ,  List<String> newlabels , int matrixcount){
        super(matrix , rows  ,columns ,  newlabels , matrixcount);
    }
    @Override
    public int rowmean(int[][] matrix1 ,int r, int col1){
        System.out.println("This is a NUll matrix , The row mean is 0");
        return 1;
    }

    @Override
    public int colmean(int[][] matrix1, int c , int row1){
        System.out.println("This is a Null matrix , The column mean is 0");
        return 1;
    }

    @Override
    public float mean(int[][] matrix1 , int row1, int col1){
        System.out.println("This is a Null matrix, The mean is 0");
        return 1;
    }

    @Override
    public int[][] dotmultiplication(int[][]matrix1 , int row1 , int col1 , int s){
        System.out.println("This will be dot multiplication with null matrix");
        for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print("0"+"\t");
	            }
	             
	            System.out.println();
	        }
        return matrix1;
    }

    @Override
    public float[][] dotdivision(int[][]matrix1 , int row1 , int col1 , int s){
        System.out.println("This will be dot division with null matrix");
        float[][] output = new float[row1][col1];
        for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
	                System.out.print("0"+"\t");
	            }
	             
	            System.out.println();
	        }
        
        //float[][] newmatrix2=new float[0][0];
        //newmatrix2[0][0]=0;
        for (int i = 0; i < row1; i++)
	        {
	            for (int j = 0; j < col1; j++)
	            {
                    output[i][j]=(float)matrix1[i][j];
                }
            }
        return output;
    }

}




