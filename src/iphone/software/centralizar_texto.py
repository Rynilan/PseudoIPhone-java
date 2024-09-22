def centralizador(texto: str, dimensao: int):
    return str("{:^" + str(dimensao) + "}").format(texto)
