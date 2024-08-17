//wrong answer 87/157
// class Solution {
// public:
//     long long maxPoints(vector<vector<int>>& points) {
        
//         long long maxsum = 0;
//         int n = points[0].size(); //columns ka number
//         int j2=0,j1=0;
//         int some=0;
//         for(int i = 0; i < points.size(); i++) {
//             int maxi = points[i][0];
//             j1=0;
//             for(int j = 1; j < points[i].size(); j++) {
//                 if(points[i][j] > maxi) {
//                     maxi = points[i][j];
//                     j1=j;
//                 }
//             }
//             maxsum += maxi;
//             if(i>0){
//                 maxsum-=abs(j2-j1);
//             }
//             j2=j1;
//         }
        
//         return maxsum;
//     }
// };

//tle 156/157
// class Solution {
// public:
//     long long maxPoints(vector<vector<int>>& points) {
//         int m = points.size(); // Total rows ki ginti
//         int n = points[0].size(); // Total columns ki ginti
//         vector<long long> prevRow(n, 0); // Previous row ke har column ke best points track karne ke liye vector

//         // First row ko initialize karna
//         for (int j = 0; j < n; j++) {
//             prevRow[j] = points[0][j]; // Pehli row ki values ko prevRow mein store karna
//         }

//         // Agli rows ko process karna shuru karna, second row se
//         for (int i = 1; i < m; i++) {
//             vector<long long> currRow(n, 0); // Current row ke best points track karne ke liye vector

//             for (int j = 0; j < n; j++) {
//                 long long maxVal = 0; // Current cell ke maximum points ka initial value

//                 // Pehli row se current column ke liye sabhi possible transitions ko consider karna
//                 for (int k = 0; k < n; k++) {
//                     maxVal = max(maxVal, prevRow[k] - abs(j - k)); // Maximum points calculate karna with penalty
//                 }

//                 currRow[j] = maxVal + points[i][j]; // Current row ke current column ka value update karna
//             }

//             prevRow = currRow; // Current row ko previous row ke roop mein update karna
//         }

//         // Last row mein se maximum value return karna
//         return *max_element(prevRow.begin(), prevRow.end());
//     }
// };


//editorial ka
class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        int rows = points.size(), cols = points[0].size();
        vector<long long> previousRow(cols);

        // Initialize the first row
        for (int col = 0; col < cols; ++col) {
            previousRow[col] = points[0][col];
        }

        // Process each row
        for (int row = 0; row < rows - 1; ++row) {
            vector<long long> leftMax(cols);
            vector<long long> rightMax(cols);
            vector<long long> currentRow(cols);

            // Calculate left-to-right maximum
            leftMax[0] = previousRow[0];
            for (int col = 1; col < cols; ++col) {
                leftMax[col] = max(leftMax[col - 1] - 1, previousRow[col]);
            }

            // Calculate right-to-left maximum
            rightMax[cols - 1] = previousRow[cols - 1];
            for (int col = cols - 2; col >= 0; --col) {
                rightMax[col] = max(rightMax[col + 1] - 1, previousRow[col]);
            }

            // Calculate the current row's maximum points
            for (int col = 0; col < cols; ++col) {
                currentRow[col] =
                    points[row + 1][col] + max(leftMax[col], rightMax[col]);
            }

            // Update previousRow for the next iteration
            previousRow = currentRow;
        }

        // Find the maximum value in the last processed row
        long long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }
};