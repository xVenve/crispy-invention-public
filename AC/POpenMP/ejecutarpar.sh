#!/bin/bash
MAGENTA='\033[0;31m'
NC='\033[0m'

echo -e "${MAGENTA}Compilando...$NC"

make

echo -e "${MAGENTA}Introduce la operacion:$NC"

read func

echo -e "${MAGENTA}Ejecutando...$NC"

./image-par $func input output

echo -e "${MAGENTA}Completado$NC"
