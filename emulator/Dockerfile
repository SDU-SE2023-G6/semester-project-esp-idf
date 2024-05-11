# Use an official Python runtime as a base image
FROM python:3.10

# Set the working directory
WORKDIR /usr/src/app

# Copy the requirements file and install dependencies
COPY requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt

# Copy the application code
COPY satelitte.py ./

# Command to run your Python script
CMD ["python", "satelitte.py"]
