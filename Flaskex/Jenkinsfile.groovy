node{
    stage("Update Jenkins"){
        properties([parameters([string(defaultValue: '54.154.125.186', description: 'Please provide IP', name: 'ENVIR', trim: true)])])
        sh "echo Parameter added"
    }
    stage("Install git"){
        sh "ssh ec2-user@${ENVIR} sudo yum install git python-pip -y"
    }
    stage("Remove Repo"){
        //sh "ssh ec2-user@${ENVIR} sudo rm -rf /home/ec2-user/flask-examples"
    }
    stage("Pull Repo"){
        sh "ssh ec2-user@${ENVIR} git clone https://github.com/chaglare/Flaskex.git"
    }
    stage("Install Requirements"){
        //sh "virtualenv /tmp/venv"
        //sh ". /tmp/venv/bin/activate"
        sh "echo Hello"
    }
    stage("Pip install"){
        sh "ssh ec2-user@${ENVIR} sudo pip install -r /home/ec2-user/Flaskex/requirements.txt"
    }
    stage("Run App"){
        sh "ssh ec2-user@${ENVIR} python /home/ec2-user/Flaskex/app.py"
    }
}