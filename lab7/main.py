import numpy as np
from scipy.interpolate import lagrange

# mamy 4 punktów w zakresie -1...2 i obliczamy dla nich f(x)
x1 = np.linspace(-1, 2, 4)
y1 = [3, 1, 2, -6]
# wyznaczamy współczynniki
F = lagrange(x1, y1)

print(f'{F}')















