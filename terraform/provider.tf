terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
      version = "6.15.0"
    }
  }
}

provider "google" {
  # Configuration options
  credentials = file(var.credentials_file)
  project     = var.project_id
  region      = var.region
}