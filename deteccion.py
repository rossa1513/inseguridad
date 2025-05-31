import time
print("Iniciando detección...")
for i in range(5):
    time.sleep(2)
    if i == 3:
        print("ALERTA: Persona con arma detectada")
    else:
        print("Todo normal.")
print("Fin de la detección.")