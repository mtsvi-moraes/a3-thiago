from flask import Flask, jsonify
from settings import Config
import json


def parse_gemini_response(response_str):
    # Remove crases e 'json' do início
    cleaned = response_str.strip().removeprefix("```json").removesuffix("```").strip()
    return json.loads(cleaned)



config = Config()

app = Flask(__name__)

@app.route("/api/hello")
def hello():
    return jsonify({"message": "Hello from Python backend!"})

@app.route("/api/goodbye")
def goodbye():
    return jsonify({"message": "Goodbye from Python backend!"})

@app.route("/")
def get_config():    
    return jsonify(
        parse_gemini_response(config.generate_content(

            
"""
Assunto: 🚨 Alerta de Segurança: Acesso suspeito à sua conta bancária

De: suporte@itauseguro-online.com.br

Para: cliente@exemplo.com

Prezado(a) cliente,

Detectamos uma atividade suspeita em sua conta na madrugada de hoje (11/06/2025), às 03:14 AM, a partir de um dispositivo desconhecido localizado em Fortaleza/CE.

Por motivos de segurança, sua conta foi temporariamente bloqueada até que possamos verificar sua identidade.

Para desbloquear sua conta e evitar a suspensão permanente, pedimos que acesse o link abaixo e confirme suas informações:

🔒 Acesse sua conta com segurança

Caso o procedimento não seja realizado nas próximas 12 horas, sua conta será suspensa automaticamente como medida preventiva.

Agradecemos sua compreensão.
Atenciosamente,
Equipe de Segurança Itaú Unibanco
suporte@itauseguro-online.com.br

Este é um e-mail automático. Não responda a esta mensagem.
"""
        )),
    )

if __name__ == "__main__":
    app.run(port=5000)