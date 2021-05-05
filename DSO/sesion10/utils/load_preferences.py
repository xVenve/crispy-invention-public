import yaml


def getPreferences(file):
    with open(file, "rb") as f:
        conf = yaml.load(f.read())
    return conf
