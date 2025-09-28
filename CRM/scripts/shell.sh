#!/bin/bash
cd CRM
ls
echo "Pipeline executado!"
pwd
sudo apt-get update && sudo apt-get install -y mailutils
echo "Apenas testando " | mail -s "Pipeline CI/CD executado" "$EMAIL_RECIPIENT"
