int main() {
  constexpr int maxsize = 100;

  double a[maxsize][maxsize] {}; // Default init
  double b[maxsize][maxsize] {}; // Default init
  double c[maxsize][maxsize]; // No init

  for (int i=0; i<maxsize; ++i) {
    for (int j=0; j<maxsize; ++j) {
      double r=0;
      for (int k=0; k<maxsize; ++k) {
        r += a[i][k] * b[k][j];
      }
      c[i][j] += r;
    }
  }
	
  return 0;
}
