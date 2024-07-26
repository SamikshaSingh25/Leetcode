class Solution {
public:
    // Large value to represent infinity
    const int INF = 1e9 + 7;
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        // Matrix to store shortest path distances from each city
        vector<vector<int>> shortestPathMatrix(n, vector<int>(n, INF));

        // Initialize shortest path matrix
        for (int i = 0; i < n; i++) {
            shortestPathMatrix[i][i] = 0;  // Distance to itself is zero
        }

        // Populate the matrix with initial edge weights
        for (const auto& edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            shortestPathMatrix[start][end] = weight;
            shortestPathMatrix[end][start] = weight;  // For undirected graph
        }

        // Compute shortest paths from each city using Bellman-Ford algorithm
        for (int i = 0; i < n; i++) {
            bellmanFord(n, edges, shortestPathMatrix[i], i);
        }

        // Find the city with the fewest number of reachable cities within the
        // distance threshold
        return getCityWithFewestReachable(n, shortestPathMatrix,
                                          distanceThreshold);
    }

private:
    // Bellman-Ford algorithm to find shortest paths from a source city
    void bellmanFord(int n, const vector<vector<int>>& edges,
                     vector<int>& shortestPathDistances, int source) {
        // Initialize distances from the source
        fill(shortestPathDistances.begin(), shortestPathDistances.end(), INF);
        shortestPathDistances[source] = 0;  // Distance to source itself is zero

        // Relax edges up to n-1 times
        for (int i = 1; i < n; i++) {
            for (const auto& edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];
                // Update shortest path distances if a shorter path is found
                if (shortestPathDistances[start] != INF &&
                    shortestPathDistances[start] + weight <
                        shortestPathDistances[end]) {
                    shortestPathDistances[end] =
                        shortestPathDistances[start] + weight;
                }
                if (shortestPathDistances[end] != INF &&
                    shortestPathDistances[end] + weight <
                        shortestPathDistances[start]) {
                    shortestPathDistances[start] =
                        shortestPathDistances[end] + weight;
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the
    // distance threshold
    int getCityWithFewestReachable(
        int n, const vector<vector<int>>& shortestPathMatrix,
        int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for
        // each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }  // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
};